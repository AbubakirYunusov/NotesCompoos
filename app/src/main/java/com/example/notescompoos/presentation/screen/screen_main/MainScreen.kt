package com.example.notescompoos.presentation.screen.screen_main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.notescompoos.R
import com.example.notescompoos.data.preferences.NotesSharedPref
import com.example.notescompoos.presentation.theme.boldWeight
import com.example.notescompoos.presentation.theme.dp18
import com.example.notescompoos.presentation.theme.dp24
import com.example.notescompoos.presentation.theme.dp60
import com.example.notescompoos.presentation.theme.dp8
import com.example.notescompoos.presentation.theme.sp16
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview
@Composable
fun MainScreenPreview() {
    MaterialTheme {
        MainScreen {
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifire: Modifier = Modifier,
    collbacTuScreen: () -> Unit,
) {
    val onBackgroundColor = MaterialTheme.colorScheme.onBackground
    val notesSharedPref = NotesSharedPref(LocalContext.current)
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(Color.White)
        systemUiController.setNavigationBarColor(Color.White)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(modifier = modifire.padding(horizontal = dp18), title = {
                Text(
                    text = stringResource(id = R.string.text_recent_notes),
                    fontWeight = FontWeight(boldWeight),
                    fontSize = sp16,
                    color = onBackgroundColor,
                )
            }, navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_menu),
                        contentDescription = null,
                        tint = onBackgroundColor,
                    )
                }
            }, actions = {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_search),
                        contentDescription = null,
                        tint = onBackgroundColor,
                    )
                }
            }
            )
        },
        bottomBar = {
            Box(
                modifier = modifire.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color.Red),
                    shape = CircleShape,
                    modifier = modifire
                        .padding(bottom = dp24)
                        .size(dp60),
                ) {
                    IconButton(
                        onClick = { collbacTuScreen() },
                        modifier = modifire.fillMaxSize(),
                    )
                    {
                        Icon(
                            modifier = modifire
                                .fillMaxSize()
                                .padding(dp8),
                            imageVector = Icons.Filled.Add,
                            contentDescription = null,
                            tint = Color.White,
                        )
                    }
                }
            }
        },
    ) { innrerPading ->
        LazyVerticalStaggeredGrid(
            modifier = modifire.padding(innrerPading),
            columns = StaggeredGridCells.Fixed(2),
            content = {
                items(notesSharedPref.getAllNotes()) { item ->
                    NotesItem(notesModel = item)
                }
            },
        )
    }
}