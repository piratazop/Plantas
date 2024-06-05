package com.example.plantas.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plantas.R
import com.example.plantas.ViewModel.PlantasViewModel
import com.example.plantas.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: PlantasViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = com.example.plantas.View.Adapter.ListAdapter()
        binding.RvList.adapter = adapter
        binding.RvList.layoutManager = GridLayoutManager(context, 2)

        viewModel.getPlantasLista().observe(viewLifecycleOwner) {
            it.let {
                Log.d("plantasid", it.toString())
                adapter.actualizar(it)
            }
            //metodo para pasar al detalle del recycler
        }
        adapter.seleccionarPlanta().observe(viewLifecycleOwner) {
          it.let {
              Log.d("Seleccionado", it.toString())
              viewModel.getPlantasDetalleByIdFromInternet(it.id)

            }
            val bundle = Bundle().apply {
                putString("Plantas", it.id.toString())
            }
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }


    }



}


