package com.example.todolist.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.data.repository.TodoListRepositoryImpl
import com.example.todolist.domain.model.TodoItem
import com.example.todolist.domain.repository.TodoListRepository
import com.example.todolist.domain.use_cases.TodoListUseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoListViewModel(
    private val todoListRepositoryImpl: TodoListRepository
) : ViewModel() {
    private var _todoList = mutableStateOf<List<TodoItem>>(emptyList())
    val todoList: State<List<TodoItem>> get() = _todoList

    init {
        fetchTodoList()
    }

    private fun fetchTodoList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val list = todoListRepositoryImpl.getTodoList()
                _todoList.value = list
            } catch (e: Exception) {
                println("Error fetching api $e")
            }
        }
    }

    fun onClickAddItem(item: TodoItem) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                todoListRepositoryImpl.addTodoItem(item)
                val newList = todoListRepositoryImpl.getTodoList()
                _todoList.value = newList
            } catch (e: Exception) {
                println("Error adding new todo item $e")
            }
        }
    }

    fun onClickDeleteItem(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                todoListRepositoryImpl.deleteTodoItem(id)
                val newList = todoListRepositoryImpl.getTodoList()
                _todoList.value = newList
            } catch (e: Exception) {
                println("Error adding new todo item $e")
            }
        }
    }

    fun onChangeCheck(id: String, checked: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                todoListRepositoryImpl.updateTodoItem(id, checked)
                val newList = todoListRepositoryImpl.getTodoList()
                _todoList.value = newList
            } catch (e: Exception) {
                println("Error adding new todo item $e")
            }
        }
    }
}