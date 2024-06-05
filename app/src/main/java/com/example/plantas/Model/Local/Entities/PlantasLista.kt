package com.example.plantas.Model.Local.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "List_Plant")
data class PlantasLista(
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val tipo: String,
    val imagen: String,
    val descripcion: String
)