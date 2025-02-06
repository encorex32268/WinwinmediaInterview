@file:OptIn(ExperimentalLayoutApi::class)

package com.lihan.winwinmediainterview.feature.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lihan.winwinmediainterview.feature.domain.mapper.toPattern
import com.lihan.winwinmediainterview.feature.domain.mapper.toPatternUI
import com.lihan.winwinmediainterview.feature.domain.model.patterns
import com.lihan.winwinmediainterview.feature.presentation.model.PatternGroupUI
import com.lihan.winwinmediainterview.ui.theme.WinwinmediaInterviewTheme

@Composable
fun ColorGroupSection(
    modifier: Modifier = Modifier,
    patternGroupUI: PatternGroupUI,
    onColorClick: (Long) -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Text(
            text = patternGroupUI.colorName
        )
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            patternGroupUI.patternUIs.forEach {
                ColorItem(
                    patternUI = it,
                    onClick = onColorClick
                )
            }
        }

    }

}

@Composable
@Preview(showSystemUi = true)
private fun ColorGroupSectionPreview() {
    val patternUIs = patterns
        .map { it.toPattern() }
        .map { it.toPatternUI() }
        .filter { it.hue == "Red" }
        .sortedBy { it.level }

    WinwinmediaInterviewTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            ColorGroupSection(
                modifier = Modifier.fillMaxWidth(),
                patternGroupUI = PatternGroupUI(
                    colorName = "Red",
                    patternUIs = patternUIs
                )
            )
        }
    }

}