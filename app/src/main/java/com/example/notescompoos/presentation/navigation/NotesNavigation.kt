package com.example.notescompoos.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notescompoos.presentation.screen.recent_notes.RecentNotesScreen
import com.example.notescompoos.presentation.screen.screen_main.MainScreen

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun NotesNavigation() {
    val navController = rememberNavController()
    val mainScreenRoute = Screens.MainScreen.route
    val recentNotesScreenRoute = Screens.RecentNotesScreen.route
    NavHost(
        navController = navController,
        startDestination = mainScreenRoute,
    ) {
        composable(mainScreenRoute) {
            MainScreen { navController.navigate(Screens.RecentNotesScreen.route) }
        }
        composable(recentNotesScreenRoute) {
            RecentNotesScreen{ navController.navigate(Screens.MainScreen.route) }
        }
    }
}