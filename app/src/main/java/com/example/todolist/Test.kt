package com.example.todolist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Test() {
    val title = "Title toast Title toast Title toast Title toast Title toast Title toast Title toast"


    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .padding(vertical = 4.dp, horizontal = 12.dp)
            .clip(
                RoundedCornerShape(8.dp)
            )
            .background(Color.Green)
            .padding(12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
            Image(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "Demo icon",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = title)
        }
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            Box(modifier = Modifier
                .width(1.dp)
                .fillMaxHeight()
                .background(Color.White))
            Text("Undo", modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Composable
@Preview
fun TestPreview() {
    Test()
}