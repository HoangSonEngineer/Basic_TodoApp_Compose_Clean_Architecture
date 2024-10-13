package com.example.todolist.domain.model

import com.google.gson.annotations.SerializedName

data class TodoItem(
    val title: String = "",
    val description: String? = "",
    val checked: Boolean = false,

    @SerializedName("_id")
    val id: String = ""
)