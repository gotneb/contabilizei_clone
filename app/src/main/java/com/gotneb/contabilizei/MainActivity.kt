package com.gotneb.contabilizei

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gotneb.contabilizei.ui.theme.ContabilizeiTheme
import com.gotneb.contabilizei.view.CreateAccountView
import com.gotneb.contabilizei.view.HomeView
import com.gotneb.contabilizei.view.LoginView
import com.gotneb.contabilizei.view.SplashView
import kotlinx.serialization.Serializable


@Serializable
object CreateAccountScreen
@Serializable
object LoginScreen
@Serializable
object HomeScreen
@Serializable
object SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContabilizeiTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    NavHost(navController = navController, startDestination = SplashScreen) {
                        composable<LoginScreen> { LoginView(navController) }
                        composable<HomeScreen> { HomeView() }
                        composable<SplashScreen> { SplashView(navController) }
                        composable<CreateAccountScreen> { CreateAccountView() }
                    }
                }
            }
        }
    }
}