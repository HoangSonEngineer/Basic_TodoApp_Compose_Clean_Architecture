package com.example.todolist.data.repository

import com.example.todolist.data.data_source.ApiService
import com.example.todolist.domain.model.TodoItem
import com.example.todolist.domain.repository.TodoListRepository

class TodoListRepositoryImpl(
    private val apiService: ApiService
): TodoListRepository {

    override suspend fun getTodoList(): List<TodoItem> {
        return apiService.getTodoList()
    }

    override suspend fun addTodoItem(item: TodoItem) {
        apiService.addTodoItem(item)
    }

    override suspend fun deleteTodoItem(id: String) {
        apiService.deleteTodoItem(id)
    }

    override suspend fun updateTodoItem(id: String, checked: Boolean) {
        val mappedCheck = mapOf("checked" to checked)
        apiService.updateTodoItem(id, mappedCheck)
    }
}