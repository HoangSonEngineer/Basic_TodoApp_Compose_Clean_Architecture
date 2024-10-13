package com.example.todolist.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.domain.model.TodoItem

@Composable
fun TodoItemView(
    item: TodoItem,
    onCheckedChange: (String, Boolean) -> Unit,
    onDelete: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(12.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = item.title,
                fontSize = 16.sp,
                maxLines = 2,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            if (item.description != null) {
                Text(
                    text = item.description,
                    maxLines = 4,
                    fontSize = 14.sp,
                    color = Color(0xff727272)
                )
            }
        }
        Row {
            Checkbox(
                checked = item.checked,
                onCheckedChange = {
                    onCheckedChange.invoke(item.id, it)
                },
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Icon_remove",
                modifier = Modifier.clickable {
                    val id = item.id
                    onDelete.invoke(id)
                })
        }
    }
}

@Composable
@Preview
fun TodoItemPreview() {
    Row {
        TodoItemView(TodoItem("ABC", "ABCD", true, "idddddd"), { _, _ -> }, { _ -> })
    }
}