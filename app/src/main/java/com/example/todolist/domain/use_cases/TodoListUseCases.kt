package com.example.todolist.domain.use_cases

data class TodoListUseCases(
    val addTodoItem: AddTodoItem,
    val getTodoList: GetTodoList,
    val deleteTodoItem: DeleteTodoItem,
    val updateTodoItem: UpdateTodoItem
)