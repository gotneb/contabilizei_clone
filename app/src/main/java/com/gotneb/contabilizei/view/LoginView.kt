package com.gotneb.contabilizei.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gotneb.contabilizei.CreateAccountScreen
import com.gotneb.contabilizei.R


@Composable
fun LoginView(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
        .fillMaxSize()
        .padding(start = 24.dp, top = 32.dp, end = 24.dp, 8.dp),
    ) {
        var cnpj by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var showPassword by remember { mutableStateOf(false) }

        Column {
            Image(
                painter = painterResource(R.drawable.contabilizei_logo3),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
                    .height(40.dp),
            )
            Text(text = "Acesse sua Conta PJ")
            Spacer(Modifier.height(16.dp))
            Text(text = "Insira seu CNPJ e sua senha.")
            Spacer(Modifier.height(16.dp))
            Text(text = "CNPJ")
            TextField(
                value = cnpj,
                onValueChange = { cnpj = it },
                placeholder = { Text(text = "Insira o CNPJ") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(Modifier.height(32.dp))
            Text(text = "Senha")
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "Insira a senha") },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                trailingIcon = {
                    TextButton(onClick = { showPassword = !showPassword }) {
                        Icon(
                            if (showPassword) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                            contentDescription = null,
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
            )
            TextButton(
                onClick = {},
                modifier = Modifier.align(Alignment.End)
            ) { Text(text = "Esqueci minha senha") }
        }

        Column {
            Text(text = "Dica: A senha da sua Conta PJ no Contabilizei Bank é diferente da senha da plataforma Contabilizei.")
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            ) {
                Text(text = "Entrar")
            }
            OutlinedButton(
                onClick = { navController.navigate(CreateAccountScreen) },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "Criar acesso")
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "Protegido por reCAPTCHA")
                Text(text = " - ")
                TextButton(
                    onClick = {},
                    contentPadding = PaddingValues(0.dp),
                ) { Text(text = "Privacidade") }
                Text(text = " - ")
                TextButton(
                    onClick = {},
                    contentPadding = PaddingValues(0.dp),
                ) { Text(text = "Termos") }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginViewPreview() {
    LoginView(navController = rememberNavController())
}