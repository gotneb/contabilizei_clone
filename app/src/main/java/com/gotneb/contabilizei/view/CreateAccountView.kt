package com.gotneb.contabilizei.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gotneb.contabilizei.R

@Composable
fun CreateAccountView() {
    var value by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, top = 0.dp, end = 32.dp, bottom = 32.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.contabilizei_logo3),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(48.dp),
        )

        Column {
            Text(text = "Boas-vindas")
            Text(text = "Você está abrindo sua Conta PJ no Contabilizei Bank!")
            Spacer(Modifier.height(8.dp))
            Text(text = "Para abrir sua Conta PJ digite o CNPJ da sua empresa.")
            Spacer(Modifier.height(32.dp))
            Text(text = "CNPJ")
            TextField(
                value = value,
                onValueChange = { value = it },
                placeholder = { Text(text = "Insira o CNPJ") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            TextButton(
                onClick = {},
                modifier = Modifier.align(Alignment.End)
            ) { Text(text = "Não lembro meu CNPJ") }
        }

        Button(
            onClick = {}
        ) {
            Text(
                text = "Continuar",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAccountViewPreview() {
    CreateAccountView()
}