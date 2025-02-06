package com.lihan.winwinmediainterview.feature.domain.repository

import com.lihan.winwinmediainterview.feature.domain.model.Pattern

interface PatternRepository {
    suspend fun getData(): List<Pattern>
}