package com.example.plantas.View

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.plantas.Model.Local.Entities.PlantasDetalle
import com.example.plantas.R
import com.example.plantas.ViewModel.PlantasViewModel
import com.example.plantas.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private  lateinit var binding: FragmentSecondBinding
    private val viewModel: PlantasViewModel by activityViewModels()
    private var plantasId: Int = 0
    private var plantasNombre: String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

       binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {bundle ->
            plantasId = bundle.getInt("plantasId")
            plantasNombre = bundle.getString("plantasNombre").toString()

        }
        plantasId.let { id ->
           viewModel.getPlantasDetalleByIdFromInternet(id)
           }

        viewModel.getPlantasDetalle().observe(viewLifecycleOwner, Observer {
            Log.d("PlantasDetalle", "PlantasDetalle")

            var tipo = it.tipo
            var nombre = it.nombre

            Glide.with(binding.imageD).load(it.imagen).into(binding.imageD)
            binding.textNameD.text = "Nombre:${it.nombre}"
            binding.textTipoD.text = "Tipo:${it.tipo}"
            binding.textDescripcionD.text = "Descripcion:${it.descripcion}"


            binding.btnCorreo.setOnClickListener {
                val intent= Intent(Intent.ACTION_SEND)
            }

        })

        }
    var _binding = null

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

    }



