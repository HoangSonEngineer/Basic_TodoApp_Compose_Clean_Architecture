package com.example.todolist.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolist.domain.model.TodoItem

@Composable
fun CreateTodoForm(onSave: (item: TodoItem) -> Unit = { _ -> }) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Please input title") },
            modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        )

        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Please input description") },
            modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        )

        Button(onClick = {
                onSave(TodoItem(title, description))
        }) {
            Text("Save")
        }
    }
}
