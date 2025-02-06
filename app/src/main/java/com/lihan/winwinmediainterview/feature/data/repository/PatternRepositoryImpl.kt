package com.lihan.winwinmediainterview.feature.data.repository

import com.lihan.winwinmediainterview.feature.domain.mapper.toPattern
import com.lihan.winwinmediainterview.feature.domain.model.Pattern
import com.lihan.winwinmediainterview.feature.domain.model.patterns
import com.lihan.winwinmediainterview.feature.domain.repository.PatternRepository
import kotlinx.coroutines.delay

class PatternRepositoryImpl: PatternRepository {
    override suspend fun getData(): List<Pattern> {
        delay(1000)
        return patterns.map { it.toPattern() }
    }
}