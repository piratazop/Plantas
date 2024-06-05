package com.example.plantas.View.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.plantas.Model.Local.Entities.PlantasLista
import com.example.plantas.databinding.PlantalistBinding
//numero4
class ListAdapter: RecyclerView.Adapter<ListAdapter.ListaViewholder>(){

private var plantasLista = listOf<PlantasLista>()
    private val selectedPlants = MutableLiveData<PlantasLista>()

//funciones copy paste
//Función para actualizar el adapter
fun actualizar(lista : List<PlantasLista>){
    plantasLista = lista
    notifyDataSetChanged()

}

    fun seleccionarPlanta(): LiveData<PlantasLista> = selectedPlants



   inner class ListaViewholder(private val binding:PlantalistBinding): RecyclerView.ViewHolder(binding.root),
            View.OnClickListener{
                fun bind (plantas:PlantasLista){
                   Glide.with(binding.imageRv).load(plantas.imagen).centerCrop().into(binding.imageRv)
                    binding.textNameRV.text= plantas.nombre
                    binding.textTipoRV.text = plantas.tipo
                    itemView.setOnClickListener(this)

                }

       override fun onClick(v: View?) {
          selectedPlants.value=plantasLista[adapterPosition]
           //numero3
       }
   }
//numero5
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewholder {
        return ListaViewholder(PlantalistBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount()= plantasLista.size

    override fun onBindViewHolder(holder: ListaViewholder, position: Int) {
        val planta = plantasLista[position]
        holder.bind(planta)
    }


}