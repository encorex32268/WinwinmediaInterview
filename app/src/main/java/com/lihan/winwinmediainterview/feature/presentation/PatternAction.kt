package com.lihan.winwinmediainterview.feature.presentation

sealed interface PatternAction {
    data class OnColorPick(val color: Long): PatternAction
}