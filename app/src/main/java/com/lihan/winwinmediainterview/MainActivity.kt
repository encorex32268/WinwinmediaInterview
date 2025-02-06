package com.lihan.winwinmediainterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lihan.winwinmediainterview.feature.presentation.PatternScreen
import com.lihan.winwinmediainterview.feature.presentation.PatternScreenRoot
import com.lihan.winwinmediainterview.feature.presentation.PatternViewModel
import com.lihan.winwinmediainterview.ui.theme.WinwinmediaInterviewTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WinwinmediaInterviewTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PatternScreenRoot()
                }
            }
        }
    }
}
