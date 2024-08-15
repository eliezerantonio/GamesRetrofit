package com.example.gamesretrofit.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gamesretrofit.components.CardGame
import com.example.gamesretrofit.components.MainTopBar
import com.example.gamesretrofit.util.Constants.Companion.CUSTOM_BLACK
import com.example.gamesretrofit.viewModel.GamesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: GamesViewModel, navController: NavController){
    Scaffold(
        topBar = {
            MainTopBar(title = "API GAMES", onClickBackButton = {}) {
                navController.navigate("SearchGameView")
            }
        }
    ) {
        ContentHomeView(viewModel, it, navController)
    }
    
}

@Composable
fun ContentHomeView(viewModel: GamesViewModel, pad:PaddingValues, navController: NavController){
    val games by viewModel.games.collectAsState()
    LazyColumn(
        modifier = Modifier
            .padding(pad)
            .background(Color(CUSTOM_BLACK))
    ){
        items(games){ item ->
            CardGame(item) {
                navController.navigate("DetailView/${item.id}")
            }
            Text(text = item.name,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp)
                )
        }
    }
}