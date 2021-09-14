package com.sherif.cryptocompose.domain.presentation.feature.coin_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sherif.cryptocompose.domain.presentation.feature.coin_screen.component.CoinComponent
import com.sherif.cryptocompose.domain.presentation.feature.coin_screen.viewmodels.CoinScreenViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinScreenViewModel = hiltViewModel()
){
    val coinState = viewModel.state.value

   Box(modifier = Modifier.fillMaxSize()) {

       LazyColumn(){
           items(coinState.coins){ coins->
               Spacer(modifier = Modifier.height(24.dp))
               CoinComponent(coin = coins, onItemClick ={
                   TODO()
               } )
               if(coinState.error.isNotBlank()) {
                   Text(
                       text = coinState.error,
                       color = MaterialTheme.colors.error,
                       textAlign = TextAlign.Center,
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(horizontal = 20.dp)
                           .align(Alignment.Center)
                   )
               }
               if(coinState.isLoading) {
                   CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
               }
           }
       }

   }
}