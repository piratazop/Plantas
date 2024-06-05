package com.example.plantas.Model.Local.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Details_Plant")//este es el nombre de la tabla
data class PlantasDetalle(
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val tipo: String,
    val imagen: String,
    val descripcion: String
)