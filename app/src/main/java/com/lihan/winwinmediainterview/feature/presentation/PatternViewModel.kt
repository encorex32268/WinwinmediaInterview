package com.lihan.winwinmediainterview.feature.presentation

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lihan.winwinmediainterview.feature.domain.mapper.toPattern
import com.lihan.winwinmediainterview.feature.domain.mapper.toPatternUI
import com.lihan.winwinmediainterview.feature.domain.repository.PatternRepository
import com.lihan.winwinmediainterview.feature.presentation.model.PatternGroupUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class PatternViewModel(
    private val repository: PatternRepository
): ViewModel(){

    private val _state = MutableStateFlow(PatternState())
    val state = _state
        .asStateFlow()
        .onStart {
            val data = repository.getData()
                .sortedBy { it.hue }
                .groupBy { it.hue }
                .map {
                    PatternGroupUI(
                        colorName = it.key,
                        patternUIs = it.value.map { it.toPatternUI() }
                            .filter { it.level > 100 }
                            .sortedBy { it.level }
                    )
                }

            _state.update {
                it.copy(
                    items = data,
                    isLoading = false
                )
            }
        }.stateIn(
            viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = _state.value
        )

    fun onAction(action: PatternAction){
        when(action){
            is PatternAction.OnColorPick -> {
                _state.update {
                    it.copy(
                        selectedColor = Color(action.color)
                    )
                }
            }
        }
    }


}