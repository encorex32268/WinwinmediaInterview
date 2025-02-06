package com.lihan.winwinmediainterview.feature.presentation

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lihan.winwinmediainterview.feature.domain.mapper.toPattern
import com.lihan.winwinmediainterview.feature.domain.mapper.toPatternUI
import com.lihan.winwinmediainterview.feature.domain.model.patterns
import com.lihan.winwinmediainterview.feature.presentation.components.ColorGroupSection
import com.lihan.winwinmediainterview.feature.presentation.model.PatternGroupUI
import com.lihan.winwinmediainterview.ui.theme.WinwinmediaInterviewTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun PatternScreenRoot(
    viewModel: PatternViewModel = koinViewModel()
){
    val state by viewModel.state.collectAsState()
    PatternScreen(
        modifier = Modifier.fillMaxSize(),
        state = state,
        onAction = viewModel::onAction
    )
}


@Composable
fun PatternScreen(
    modifier: Modifier = Modifier,
    state: PatternState,
    onAction: (PatternAction) -> Unit = {}
) {
    val scope = rememberCoroutineScope()
    val backgroundAnimatable = remember {
        Animatable(
            initialValue = state.selectedColor
        )
    }
    Column(
        modifier = modifier
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(backgroundAnimatable.value)
        )
        if (state.isLoading){
            Box(
                modifier = Modifier.fillMaxWidth().weight(1f),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator(
                    modifier = Modifier.size(36.dp)
                )
            }
        }else{
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ){
                state.items.forEach {
                    ColorGroupSection(
                        modifier = Modifier.fillMaxWidth(),
                        patternGroupUI = it,
                        onColorClick = {
                            scope.launch {
                                backgroundAnimatable.animateTo(
                                    targetValue = Color(it),
                                    animationSpec = tween(
                                        durationMillis = 500
                                    )
                                )
                            }
                            onAction(PatternAction.OnColorPick(it))
                        }
                    )
                }
            }

        }


    }


}


@Preview(showSystemUi = true)
@Composable
private fun PatternScreenPreview(){
    val data = patterns.map { it.toPattern() }
        .sortedBy { it.hue }
        .groupBy { it.hue }
        .toMutableMap()
        .map {
            PatternGroupUI(
                colorName = it.key,
                patternUIs = it.value.map { it.toPatternUI() }.sortedBy { it.level }
            )
        }
    WinwinmediaInterviewTheme {
        PatternScreen(
            modifier = Modifier.fillMaxSize(),
            state = PatternState(
                items =data
            ),
            onAction = {}
        )
    }
}