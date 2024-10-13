package com.example.todolist.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavigation(todoListViewModel: TodoListViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "Home") {
        composable("Home") { MainScreen(navController, todoListViewModel) }
        composable("AddTodo") { CreateTodoScreen(navController, todoListViewModel) }
    }
}