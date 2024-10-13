package com.example.todolist.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolist.domain.model.TodoItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTodoScreen(navController: NavController, todoListViewModel: TodoListViewModel) {
    val showPopup = remember {
        mutableStateOf(false)
    }

    fun onSave(item: TodoItem) {
        todoListViewModel.onClickAddItem(item)
        showPopup.value = true
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Add new work") }, navigationIcon = {
            IconButton(onClick = {
                navController.navigate("Home") {
                    popUpTo("Home") { inclusive = true }
                }
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Menu")
            }
        })
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            CreateTodoForm(::onSave)
            if (showPopup.value) {
                Popup {
                    showPopup.value = false
                }
            }
        }
    }
}