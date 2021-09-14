package com.sherif.cryptocompose.domain.presentation.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sherif.cryptocompose.domain.presentation.feature.coin_screen.CoinListScreen
import com.sherif.cryptocompose.domain.presentation.feature.coin_screen.CoinListState
import com.sherif.cryptocompose.domain.presentation.feature.coin_screen.component.CoinComponent
import com.sherif.cryptocompose.domain.presentation.feature.coin_screen.viewmodels.CoinScreenViewModel
import com.sherif.cryptocompose.domain.presentation.theme.CryptoComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("Oncreate was Called!")
        setContent {
            CryptoComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

//                        CoinListScreen()
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "coinScreenroute"
                    ) {
                        composable("coinScreenroute"){
                            CoinListScreen(navController = navController)

                        }


                    }



                    }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoComposeTheme {
        Greeting("Android")
    }
}