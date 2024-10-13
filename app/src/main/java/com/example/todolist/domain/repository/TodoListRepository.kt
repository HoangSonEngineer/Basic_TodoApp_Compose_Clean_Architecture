package com.example.todolist.domain.repository

import com.example.todolist.domain.model.TodoItem

interface TodoListRepository {
    suspend fun getTodoList(): List<TodoItem>

    suspend fun addTodoItem(item: TodoItem)

    suspend fun deleteTodoItem(id: String)

    suspend fun updateTodoItem(id: String, checked: Boolean)
}