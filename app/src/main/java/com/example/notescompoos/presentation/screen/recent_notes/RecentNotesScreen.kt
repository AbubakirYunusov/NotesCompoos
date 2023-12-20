package com.example.notescompoos.presentation.screen.recent_notes

import com.example.notescompoos.R
import com.example.notescompoos.data.model.NotesModel
import com.example.notescompoos.data.preferences.NotesSharedPref
import com.example.notescompoos.presentation.theme.sp18
import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notescompoos.presentation.theme.NotesBackground
import com.example.notescompoos.presentation.theme.dp14
import com.example.notescompoos.presentation.theme.normolWeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
fun Preview() {
    RecentNotesScreen(callBack = {})
}

@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecentNotesScreen(
    modifier: Modifier = Modifier,
    callBack: () -> Unit,
) {
    val notesSharedPref = NotesSharedPref(LocalContext.current)
    val onBackgroundColor = MaterialTheme.colorScheme.onBackground
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(NotesBackground)
        systemUiController.setNavigationBarColor(NotesBackground)
    }

    var notesTitleState by remember {
        mutableStateOf("")
    }
    var notesDetailStates by remember {
        mutableStateOf("")
    }

    Scaffold(
        containerColor = NotesBackground,
        topBar = {
            CenterAlignedTopAppBar(modifier = modifier.padding(10.dp),
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = NotesBackground
                ),
                title = {
                    Text(
                        text = stringResource(id = R.string.text_add_note),
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = onBackgroundColor,
                        textAlign = TextAlign.Center,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        callBack()
                    }) {
                        Icon(
                            painterResource(id = R.drawable.icon_back),
                            null,
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        if (notesTitleState.isNotEmpty() && notesDetailStates.isNotEmpty()) {
                            callBack()
                            notesSharedPref.saveNote(
                                NotesModel(
                                    noteTitel = notesTitleState, noteDescription = notesDetailStates
                                )
                            )
                        }
                    }) {
                        Icon(
                            painterResource(id = R.drawable.icon_check),
                            null,
                        )
                    }
                }
            )
        },

        content = { innerPadding ->
            Column {
                OutlinedTextField(
                    modifier = modifier
                        .padding(innerPadding)
                        .padding(dp14)
                        .fillMaxWidth(),
                    value = notesTitleState,
                    onValueChange = { notesTitleState = it },
                    label = {
                        Text(
                            text = stringResource(id = R.string.text_title),
                            fontWeight = FontWeight(normolWeight),
                            fontSize = sp18,
                        )
                    },
                )
                OutlinedTextField(
                    modifier = modifier
                        .padding(dp14)
                        .fillMaxWidth(),
                    value = notesDetailStates,
                    onValueChange = { notesDetailStates = it },
                    label = {
                        Text(
                            text = stringResource(id = R.string.text_description),
                            fontWeight = FontWeight(normolWeight),
                            fontSize = sp18,
                        )
                    },
                )
            }
        },
    )
}