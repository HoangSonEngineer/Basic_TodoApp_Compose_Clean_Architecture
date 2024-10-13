package com.example.todolist.domain.use_cases

import com.example.todolist.domain.repository.TodoListRepository

class GetTodoList(private val todoListRepository: TodoListRepository) {
    suspend operator fun invoke() = todoListRepository.getTodoList()
}