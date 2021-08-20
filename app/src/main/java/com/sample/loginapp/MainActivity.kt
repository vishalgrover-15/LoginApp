package com.sample.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.sample.loginapp.ui.UserDashboardScreen
import com.sample.loginapp.ui.UserLoginScreen
import com.sample.loginapp.ui.theme.LoginAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "user_login_screen"
                ) {
                    composable("user_login_screen") {
                        UserLoginScreen(navController = navController,this@MainActivity)
                    }
                    composable(
                        "user_dashboard_screen/{userName}",
                        arguments = listOf(
                            navArgument("userName") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val userName = remember {
                            it.arguments?.getString("userName")
                        }
                        UserDashboardScreen(userName = userName, navController = navController)

                    }
                }

            }


        }

    }

}


