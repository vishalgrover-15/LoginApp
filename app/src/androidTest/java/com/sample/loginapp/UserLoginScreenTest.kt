package com.sample.loginapp

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sample.loginapp.ui.UserLoginScreen
import com.sample.loginapp.ui.theme.LoginAppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UserLoginScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun login_screen_empty_username_and_password() {
        composeTestRule.setContent {
            LoginAppTheme {
                UserLoginScreen(navController = rememberNavController(),composeTestRule.activity)
            }
        }

        composeTestRule.onNodeWithText("Enter Username").performTextInput("")
        composeTestRule.onNodeWithText("Enter Password").performTextInput("")
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Login").assertIsNotEnabled() // login button will remain disabled when both fields are left empty
    }

    @Test
    fun login_screen_empty_username_only() {
        composeTestRule.setContent {
            LoginAppTheme {
                UserLoginScreen(navController = rememberNavController(),composeTestRule.activity)
            }
        }

        composeTestRule.onNodeWithText("Enter Username").performTextInput("")
        composeTestRule.onNodeWithText("Enter Password").performTextInput("123456")
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Login").assertIsNotEnabled() // login button will remain disabled when username is  left empty
    }

    @Test
    fun login_screen_empty_password_only() {
        composeTestRule.setContent {
            LoginAppTheme {
                UserLoginScreen(navController = rememberNavController(),composeTestRule.activity)
            }
        }

        composeTestRule.onNodeWithText("Enter Username").performTextInput("vishal")
        composeTestRule.onNodeWithText("Enter Password").performTextInput("")
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Login").assertIsNotEnabled() // login button will remain disabled password is left empty
    }

    @Test
    fun login_screen_non_empty_fields() {
        composeTestRule.setContent {
            LoginAppTheme {
                UserLoginScreen(navController = rememberNavController(),composeTestRule.activity)
            }
        }

        composeTestRule.onNodeWithText("Enter Username").performTextInput("vishal")
        composeTestRule.onNodeWithText("Enter Password").performTextInput("123456")
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Login").assertIsEnabled() // login button is enabled when username and password are filled
    }
}