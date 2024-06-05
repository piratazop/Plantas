package com.example.plantas.Model.Remoto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitPlant {

    companion object {

    private const val BASE_URL = "https://my-json-server.typicode.com/mauricioponce/TDApi/"

    lateinit var retrofitInstance: Retrofit

    //Esta funcion se llama en el repositorio
    fun getRetrofit(): PlantApi {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        return retrofit.create(PlantApi::class.java)
    }
}

}