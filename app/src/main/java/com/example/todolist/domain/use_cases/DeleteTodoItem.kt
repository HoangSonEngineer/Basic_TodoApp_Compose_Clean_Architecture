package com.example.todolist.domain.use_cases

import com.example.todolist.domain.repository.TodoListRepository

class DeleteTodoItem(
    private val todoListRepository: TodoListRepository
) {
    suspend operator fun invoke(id: String) = todoListRepository.deleteTodoItem(id)
}