package com.lihan.winwinmediainterview.feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.winwinmediainterview.feature.presentation.model.PatternUI
import com.lihan.winwinmediainterview.ui.theme.WinwinmediaInterviewTheme

@Composable
fun ColorItem(
    modifier: Modifier = Modifier,
    patternUI: PatternUI,
    onClick: (Long) -> Unit = {}
) {
    Box(
        modifier = modifier
            .size(60.dp)
            .background(
                shape = CircleShape,
                color = Color(patternUI.color)
            )
            .pointerInput(Unit){
                detectTapGestures {
                    onClick(patternUI.color)
                }
            }
        ,
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.padding(8.dp),
            text = patternUI.level.toString()
        )
    }

}

@Preview(showSystemUi = true)
@Composable
private fun ColorItemPreview(){
    WinwinmediaInterviewTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            ColorItem(
                patternUI = PatternUI(
                    hue = "Red",
                    level = 200,
                    color = 0xFFC62828
                )
            )
        }
    }
}