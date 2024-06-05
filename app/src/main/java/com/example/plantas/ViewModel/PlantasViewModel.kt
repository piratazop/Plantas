package com.example.plantas.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.ListPreloader
import com.example.plantas.Model.Local.Database.PlantDatabase
import com.example.plantas.Model.Local.Entities.PlantasDetalle
import com.example.plantas.Model.Local.Entities.PlantasLista
import com.example.plantas.Model.Remoto.PlantRepositorio
import kotlinx.coroutines.launch

class PlantasViewModel (application: Application) : AndroidViewModel(application){

   private val repository : PlantRepositorio
   private var idSelected : Int = 0

   init {

      val bd = PlantDatabase.getdatabase(application)
      val Dao = bd.getPlantDao()
      repository = PlantRepositorio(Dao)
      viewModelScope.launch {
         repository.fetchLista()
      }
   }
fun getPlantasLista(): LiveData<List<PlantasLista>> = repository.plantasListaLiveData



   fun getPlantasDetalleByIdFromInternet(id: Int)= viewModelScope.launch {
      idSelected = id
      repository.fetchPlantasDetalle(id)
   }


fun getPlantasDetalle(): LiveData<PlantasDetalle> = repository.getPlantasDetalleById(idSelected)


}