package com.gotneb.contabilizei.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gotneb.contabilizei.CreateAccountScreen
import com.gotneb.contabilizei.LoginScreen
import com.gotneb.contabilizei.R


@Composable
fun SplashView(navController: NavController) {
    val colorStops = arrayOf(
        0.0f to Color(0xFF40c9ff),
        0.15f to Color(0xFF002665),
        0.85f to Color(0xFF002665),
        1f to Color(0xFF124494),
    )
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.horizontalGradient(colorStops = colorStops)),
    ) {
        // Background image
        Column(verticalArrangement = Arrangement.Bottom) {
            Image(
                painter = painterResource(R.drawable.splash_screen),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f)

            )
            Spacer(Modifier.fillMaxHeight(0.3f))
        }
        // Actual content
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize().padding(horizontal = 64.dp, vertical = 24.dp),
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Bem-vindo a")
                Spacer(Modifier.height(8.dp))
                Image(
                    painter = painterResource(R.drawable.contabilizei_logo2),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                Text("Todos os pontos em um único ponto")
            }
            Column {
                Button(
                    onClick = { navController.navigate(CreateAccountScreen) },
                    modifier = Modifier.fillMaxWidth(),
                ) { Text("Criar Acesso") }
                Spacer(Modifier.height(12.dp))
                OutlinedButton(
                    onClick = { navController.navigate(LoginScreen) },
                    modifier = Modifier.fillMaxWidth(),
                ) { Text("Entrar com Login e Senha") }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashViewPreview() {
    SplashView(rememberNavController())
}