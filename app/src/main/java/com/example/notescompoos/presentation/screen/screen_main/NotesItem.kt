package com.example.notescompoos.presentation.screen.screen_main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.notescompoos.data.model.NotesModel
import com.example.notescompoos.presentation.theme.NotesGrey
import com.example.notescompoos.presentation.theme.boldWeight
import com.example.notescompoos.presentation.theme.dp10
import com.example.notescompoos.presentation.theme.dp12
import com.example.notescompoos.presentation.theme.dp150
import com.example.notescompoos.presentation.theme.dp16
import com.example.notescompoos.presentation.theme.dp18
import com.example.notescompoos.presentation.theme.dp8
import com.example.notescompoos.presentation.theme.normolWeight
import com.example.notescompoos.presentation.theme.sp12
import com.example.notescompoos.presentation.theme.sp16

@Preview
@Composable
fun NotesItemPreview() {
    MaterialTheme {
        NotesItem(
            NotesModel(
                noteTitel = "Shopping List",
                noteDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore maconsequat. deserunt mollit anim id est laborum."
            )
        )
    }
}

@Composable
fun NotesItem(
    notesModel: NotesModel,
    modifier: Modifier = Modifier,
) {
    val onBackgroundColor = MaterialTheme.colorScheme.onBackground

    Card(
        shape = RoundedCornerShape(dp16), modifier = modifier
            .width(dp150)
            .padding(dp10)
    ) {
        Column {
            Text(
                modifier = modifier
                    .padding(dp8)
                    .fillMaxWidth(),
                text = notesModel.noteTitel,
                fontSize = sp16,
                fontWeight = FontWeight(boldWeight),
                color = onBackgroundColor,
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = modifier
                    .padding(horizontal = dp12)
                    .padding(bottom = dp12)
                    .fillMaxWidth(),
                text = notesModel.noteDescription,
                fontSize = sp12,
                fontWeight = FontWeight(normolWeight),
                color = NotesGrey,
                textAlign = TextAlign.Center,
            )
        }
    }
}