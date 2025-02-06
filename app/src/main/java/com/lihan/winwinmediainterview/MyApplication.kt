package com.lihan.winwinmediainterview

import android.app.Application
import com.lihan.winwinmediainterview.feature.di.patternModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                patternModule
            )
        }
    }
}