package com.gotneb.contabilizei.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gotneb.contabilizei.HomeScreen
import com.gotneb.contabilizei.R


@Composable
fun LoginView(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
            .background(Color(0xFF293581))
            .fillMaxWidth()
            .fillMaxHeight(.3f))
        {
            Image(
                painter = painterResource(R.drawable.contabilizei_logo),
                contentDescription = null,
                modifier = Modifier.size(180.dp)
            )
        }

        var userText by remember { mutableStateOf("") }
        var showPassword by remember { mutableStateOf(false) }
        var password by remember { mutableStateOf("") }

        Column(Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = userText,
                onValueChange = { userText = it },
                label = { Text("Usuário") },
                placeholder = { Text("Digite seu e-mail ou cpf") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Senha") },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    TextButton(onClick = { showPassword = !showPassword }) {
                        Icon(
                            imageVector = if (showPassword) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff,
                            contentDescription = "See password",
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(Modifier.height(8.dp))
            TextButton(
                onClick = {},
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.fillMaxWidth()
            ) { Text("Esqueci minha senha") }
            Button(
                onClick = { navController.navigate(HomeScreen) },
                contentPadding = PaddingValues(8.dp),
                enabled = (userText.isNotEmpty() && password.isNotEmpty()),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Acessar")
            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = "- ou use login social -",
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
            Spacer(Modifier.height(8.dp))
            OutlinedButton(
                onClick = {},
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.google_logo),
                    contentDescription = null,
                    alignment = Alignment.CenterEnd,
                    modifier = Modifier.size(20.dp),
                )
                Spacer(Modifier.width(16.dp))
                Text("Entrar com Google")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginViewPreview() {
    LoginView(navController = rememberNavController())
}