package com.example.todolist.data.data_source

import com.example.todolist.domain.model.TodoItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET(".")
    suspend fun getTodoList(): List<TodoItem>

    @POST("/add")
    suspend fun addTodoItem(@Body item: TodoItem)

    @DELETE("/delete/{id}")
    suspend fun deleteTodoItem(@Path("id") id: String)

    @PUT("/update/{id}")
    suspend fun updateTodoItem(@Path("id") id: String, @Body checked: Map<String, Boolean>)
}

