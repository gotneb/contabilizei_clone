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
import com.gotneb.contabilizei.view.HomeView
import com.gotneb.contabilizei.view.LoginView
import kotlinx.serialization.Serializable


@Serializable
object LoginDest
@Serializable
object HomeDest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContabilizeiTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    NavHost(navController = navController, startDestination = LoginDest) {
                        composable<LoginDest> { LoginView(navController) }
                        composable<HomeDest> { HomeView() }
                    }
                }
            }
        }
    }
}