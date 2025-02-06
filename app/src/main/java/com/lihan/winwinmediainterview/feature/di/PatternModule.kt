package com.lihan.winwinmediainterview.feature.di

import com.lihan.winwinmediainterview.feature.data.repository.PatternRepositoryImpl
import com.lihan.winwinmediainterview.feature.domain.repository.PatternRepository
import com.lihan.winwinmediainterview.feature.presentation.PatternViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val patternModule = module {
    single { PatternRepositoryImpl() }.bind<PatternRepository>()
    viewModelOf(::PatternViewModel)
}