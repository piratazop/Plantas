package com.example.plantas.Model.Local.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.plantas.Model.Local.Dao.PlantDao
import com.example.plantas.Model.Local.Entities.PlantasDetalle
import com.example.plantas.Model.Local.Entities.PlantasLista

@Database(entities = [PlantasLista::class,PlantasDetalle::class], version = 1, exportSchema = false)
abstract class PlantDatabase : RoomDatabase(){

    abstract fun getPlantDao(): PlantDao

    companion object {


        @Volatile
        private var INSTANCE: PlantDatabase? = null

        fun getdatabase(context: Context): PlantDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                   PlantDatabase::class.java,
                    "plant_database"
                    ).build()
                INSTANCE = instance
                return instance

            }
        }
    }
}