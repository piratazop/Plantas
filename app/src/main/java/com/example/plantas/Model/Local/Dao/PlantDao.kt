package com.example.plantas.Model.Local.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.plantas.Model.Local.Entities.PlantasDetalle
import com.example.plantas.Model.Local.Entities.PlantasLista


@Dao
interface PlantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPlantas(plantasLista: List<PlantasLista>)

    @Query("SELECT * FROM List_Plant ORDER BY id ASC")
    fun getAllPlantas(): LiveData<List<PlantasLista>>//live dsta para observar los resultados

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlantasDetalle(plantasDetalle: PlantasDetalle)

    @Query("SELECT * FROM Details_Plant WHERE id = :id")
    fun getPlantasDetalleById(id: Int): LiveData<PlantasDetalle>






}