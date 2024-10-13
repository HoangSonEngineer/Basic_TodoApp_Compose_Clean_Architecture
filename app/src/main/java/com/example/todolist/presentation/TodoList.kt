package com.example.todolist.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.todolist.domain.model.TodoItem


@Composable
fun TodoList(
    data: List<TodoItem>,
    onChecked: (String, Boolean) -> Unit,
    onDelete: (String) -> Unit
) {
    LazyColumn {
        data.map {
            item {
                TodoItemView(
                    it,
                    onCheckedChange = { id, checked -> onChecked(id, checked) },
                    onDelete = { _ -> onDelete(it.id) })
            }
        }
    }
}
