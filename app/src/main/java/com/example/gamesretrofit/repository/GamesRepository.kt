package com.example.gamesretrofit.repository

import com.example.gamesretrofit.data.ApiGames
import com.example.gamesretrofit.model.GameList
import com.example.gamesretrofit.model.GamesModel
import com.example.gamesretrofit.model.SingleGameModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: ApiGames) {

    suspend fun getGames(): List<GameList>? {
        val response = apiGames.getGames()
        if (response.isSuccessful){
            return response.body()?.results
        }
        return null
    }

    suspend fun getGameById(id: Int): SingleGameModel? {
        val response = apiGames.getGameById(id)
        if(response.isSuccessful){
            return response.body()
        }
        return null
    }

    suspend fun  getGameByName(name: String):SingleGameModel?{
        val response = apiGames.getGamesByName(name)
        if(response.isSuccessful){
            return  response.body()
        }

        return null
    }

    suspend fun getGamesPaging(page:Int, pageSize:Int): GamesModel {

        delay(timeMillis = 3000L)
        return apiGames.getGamesPaging(page, pageSize)
    }

}