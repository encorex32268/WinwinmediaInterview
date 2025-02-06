package com.lihan.winwinmediainterview.feature.presentation

import androidx.compose.ui.graphics.Color
import com.lihan.winwinmediainterview.feature.presentation.model.PatternGroupUI

data class PatternState(
    val isLoading: Boolean = true,
    val selectedColor: Color = Color.LightGray,
    val items: List<PatternGroupUI> = emptyList()
)
