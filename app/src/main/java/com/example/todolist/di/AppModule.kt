package com.example.todolist.di

import com.example.todolist.data.data_source.ApiService
import com.example.todolist.data.repository.TodoListRepositoryImpl
import com.example.todolist.domain.repository.TodoListRepository
import com.example.todolist.presentation.TodoListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val todoAppModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.3:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    single<TodoListRepository> {
        TodoListRepositoryImpl(get())
    }

    viewModel {
        TodoListViewModel(get())
    }
}