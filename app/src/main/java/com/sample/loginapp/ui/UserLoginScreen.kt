package com.sample.loginapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UserLoginScreen(navController: NavController) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        val scaffoldState = rememberScaffoldState()

        val usernameState = remember {
            mutableStateOf("")
        }
        val passwordState = remember {
            mutableStateOf("")
        }

        /**
         * This function is called whenever user updates the text in any of the inputfield
         * checks for if any input is empty, login button will be disabled
         *
         * @return true/false
         */
        fun onTextChanged(): Boolean {
            return (usernameState.value.isNotEmpty() && passwordState.value.isNotEmpty())
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                TextField(
                    label = "Enter Username", Modifier.fillMaxWidth(), usernameState,
                    KeyboardOptions(keyboardType = KeyboardType.Text), VisualTransformation.None
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    label = "Enter Password",
                    Modifier.fillMaxWidth(),
                    passwordState,
                    KeyboardOptions(keyboardType = KeyboardType.Password),
                    PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {
                        navController.navigate("user_dashboard_screen/${usernameState.value}")
                    },
                    enabled = onTextChanged()
                ) {
                    Text(text = "Login")

                }
            }

        }
    }
}


@Composable
fun TextField(
    label: String,
    modifier: Modifier,
    mutableState: MutableState<String>,
    keyboardOptions: KeyboardOptions,
    visualTransformation: VisualTransformation
) {
    TextField(
        value = mutableState.value,
        label = {
            Text(text = label)
        },
        onValueChange = {
            mutableState.value = it
        },
        singleLine = true,
        modifier = modifier,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Normal)

    )
}