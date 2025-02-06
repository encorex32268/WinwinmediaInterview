package com.lihan.winwinmediainterview.feature.domain.mapper

import com.lihan.winwinmediainterview.feature.data.model.PatternDto
import com.lihan.winwinmediainterview.feature.domain.model.Pattern
import com.lihan.winwinmediainterview.feature.presentation.model.PatternUI


fun PatternDto.toPattern(): Pattern{
    return Pattern(
        hue = hue,
        level = level,
        color = color
    )
}

fun Pattern.toPatternUI(): PatternUI{
    return PatternUI(
        hue = hue,
        level = level,
        color = color
    )
}
