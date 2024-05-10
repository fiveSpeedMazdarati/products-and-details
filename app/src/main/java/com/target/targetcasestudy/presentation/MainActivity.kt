package com.target.targetcasestudy.presentation

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier

@AndroidEntryPoint
class MainActivity() : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MaterialTheme {
        Surface (
          modifier = Modifier.fillMaxSize()
        ) {
            Text("Hello!")
          }
        }
      }

    }
  }
