package com.example.spotifyclone.Model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SpotifyAPI {

    @GET("pd.json.json?alt=media&token=34623b89-7a9b-4c67-8eb5-c13b25da2f9f")
    fun ListCategorias(): Call<Categorias>

}

fun retrofit(): Retrofit = Retrofit.Builder()
    .baseUrl("https://firebasestorage.googleapis.com/v0/b/spotify-55d37.appspot.com/o/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()