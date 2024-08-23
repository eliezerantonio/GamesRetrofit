package com.example.gamesretrofit.data

import androidx.compose.foundation.pager.PageSize
import com.example.gamesretrofit.model.GamesModel
import com.example.gamesretrofit.model.SingleGameModel
import com.example.gamesretrofit.util.Constants.Companion.API_KEY
import com.example.gamesretrofit.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiGames {

    @GET(ENDPOINT + API_KEY )
    suspend fun getGames(): Response<GamesModel>
    @GET(ENDPOINT + API_KEY)
    suspend fun getGamesPaging(@Query("") page: Int, @Query("page_size") pageSize: Int): GamesModel

    @GET("$ENDPOINT/{id}$API_KEY")
    suspend fun getGameById(@Path(value = "id")id : Int): Response<SingleGameModel>

    @GET("$ENDPOINT/{name}${API_KEY}")
    suspend fun getGamesByName(@Path(value="name")name:String):Response<SingleGameModel>

}