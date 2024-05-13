package com.target.targetcasestudy

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.target.targetcasestudy.presentation.deal_list.DealsListScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DealsListTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun header_visible() {

        rule.setContent {
            val navController = rememberNavController()
            DealsListScreen(navController = navController)
            }

        //rule.onNode()
        }
    }
