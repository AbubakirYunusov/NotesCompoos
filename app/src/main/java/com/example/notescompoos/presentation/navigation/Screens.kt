package com.example.notescompoos.presentation.navigation

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import com.example.notescompoos.R

@SuppressLint("SupportAnnotationUsage")
sealed class Screens(@StringRes val route: String) {
    object MainScreen:Screens(route = (R.string.route_main_screen.toString()))
    object RecentNotesScreen:Screens(route = (R.string.route_recent_notes_screen.toString()))
}