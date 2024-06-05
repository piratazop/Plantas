package com.example.plantas.Model.Remoto

import com.example.plantas.Model.Remoto.FromInternet.DetallePlantas
import com.example.plantas.Model.Remoto.FromInternet.ListaPlantas
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PlantApi {
    @GET("plantas")//nombre la ultima extension de la direccion
    suspend fun fetchListaPlantas(): Response<List<ListaPlantas>>
//aca llamo a la entidad de internet  Lista Plantas

    // seleccionar uno

    @GET("plantas/{id}")
    suspend fun fetchDetallePlantas(@Path("id") id: Int): Response<DetallePlantas>


    //aca puede ir @Delete @Update hay apis que se requiere permiso para eliminar otras no depende
}







