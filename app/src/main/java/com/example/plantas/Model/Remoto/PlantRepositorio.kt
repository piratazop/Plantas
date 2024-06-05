package com.example.plantas.Model.Remoto

import android.telecom.Call.Details
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.plantas.Model.Local.Dao.PlantDao
import com.example.plantas.Model.Local.Entities.PlantasDetalle
import com.example.plantas.Model.Remoto.FromInternet.DetallePlantas

class PlantRepositorio(private val plantDao: PlantDao) {
private val networkService = RetrofitPlant.getRetrofit()
//llama a la conexión
    val plantasListaLiveData = plantDao.getAllPlantas()

//aca se llama al metodo fetch desde lam api
    suspend fun fetchLista() {
        val service = kotlin.runCatching { networkService.fetchListaPlantas()}
        service.onSuccess {

            when (it.code()) {
                in 200..299 -> it.body()?.let {

                    Log.d("Flowers", it.toString())

                    plantDao.insertAllPlantas(fromInternetListaPlantas(it))
                }

                else -> Log.d("Repo", "${it.code()}-${it.errorBody()}")
            }


            }
            service.onFailure {
                Log.e("Error", "${it.message}")
            }
        }
    suspend fun fetchPlantasDetalle(id:Int):PlantasDetalle?{
        val service = kotlin.runCatching { networkService.fetchDetallePlantas(id)}

        return service.getOrNull()?.body()?.let {details ->

            val plantasDetalle = fromInternetDetallePlantas(details)
            plantDao.insertPlantasDetalle(plantasDetalle)
            plantasDetalle
        }
    }
    fun getPlantasDetalleById(id:Int): LiveData<PlantasDetalle>{
        return plantDao.getPlantasDetalleById(id)

    }
    }





