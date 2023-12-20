package com.example.notescompoos.data.model

import java.util.UUID

data class NotesModel(
    val notesId: String = UUID.randomUUID().toString(),
    val noteTitel: String,
    val noteDescription: String,
)