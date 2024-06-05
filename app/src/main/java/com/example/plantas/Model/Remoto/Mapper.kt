package com.example.plantas.Model.Remoto

import com.example.plantas.Model.Local.Entities.PlantasDetalle
import com.example.plantas.Model.Local.Entities.PlantasLista
import com.example.plantas.Model.Remoto.FromInternet.DetallePlantas
import com.example.plantas.Model.Remoto.FromInternet.ListaPlantas

fun fromInternetListaPlantas(plantasLista: List<ListaPlantas>):List<PlantasLista> {
//LOCAL a lo REMOTOa lo LOCAL, con minuscula porque es instancia ny no clase
    return plantasLista.map {

        PlantasLista(
            id = it.id,
            nombre = it.nombre,
            tipo = it.tipo,
            imagen = it.imagen,
            descripcion = it.descripcion
        )
    }
}
//REMOTO REMOTO LOCAL
fun fromInternetDetallePlantas(detallePlantas: DetallePlantas ):PlantasDetalle{

    return PlantasDetalle(
        id = detallePlantas.id,
        nombre = detallePlantas.nombre,
        tipo = detallePlantas.tipo,
        imagen = detallePlantas.imagen,
        descripcion = detallePlantas.descripcion
    )



}