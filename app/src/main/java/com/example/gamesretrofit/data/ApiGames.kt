package com.example.gamesretrofit.data

import com.example.gamesretrofit.model.GamesModel
import com.example.gamesretrofit.model.SingleGameModel
import com.example.gamesretrofit.util.Constants.Companion.API_KEY
import com.example.gamesretrofit.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiGames {

    @GET(ENDPOINT + API_KEY )
    suspend fun getGames(): Response<GamesModel>

    @GET("$ENDPOINT/{id}$API_KEY")
    suspend fun getGameById(@Path(value = "id")id : Int): Response<SingleGameModel>

}