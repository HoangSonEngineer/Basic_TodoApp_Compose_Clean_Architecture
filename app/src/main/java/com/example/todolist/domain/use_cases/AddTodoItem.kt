package com.example.todolist.domain.use_cases

import com.example.todolist.domain.model.TodoItem
import com.example.todolist.domain.repository.TodoListRepository

class AddTodoItem(
    private val todoListRepository: TodoListRepository
) {
    suspend operator fun invoke(item: TodoItem) = todoListRepository.addTodoItem(item)
}