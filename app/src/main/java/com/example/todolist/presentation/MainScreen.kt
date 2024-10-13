package com.example.todolist.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, todoListViewModel: TodoListViewModel = viewModel()) {
    val todoList by todoListViewModel.todoList

    fun onChecked(id: String, checked: Boolean) {
        todoListViewModel.onChangeCheck(id, checked)
    }

    fun onDelete(id: String) {
        todoListViewModel.onClickDeleteItem(id)
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Todo List") }, actions = {
            IconButton(onClick = {
                navController.navigate("AddTodo")
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Menu")
            }
        })
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            TodoList(todoList, onChecked = { id, checked -> onChecked(id, checked) }, onDelete = {id -> onDelete(id)})
        }
    }
}

