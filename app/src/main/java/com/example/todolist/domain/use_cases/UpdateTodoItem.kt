package com.example.todolist.domain.use_cases

import com.example.todolist.domain.repository.TodoListRepository

class UpdateTodoItem(
    private val todoListRepository: TodoListRepository
) {
    suspend operator fun invoke(id: String, checked: Boolean) =
        todoListRepository.updateTodoItem(id, checked)
}