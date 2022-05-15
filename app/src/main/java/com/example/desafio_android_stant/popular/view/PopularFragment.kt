package com.example.desafio_android_stant.popular.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio_android_stant.data.adapters.MoviesAdapter
import com.example.desafio_android_stant.data.models.ResponseResultModel
import com.example.desafio_android_stant.databinding.FragmentPopularBinding
import com.example.desafio_android_stant.popular.repository.PopularMoviesRepository
import com.example.desafio_android_stant.popular.viewmodel.PopularViewModel

class PopularFragment : Fragment() {

    private var _binding: FragmentPopularBinding? = null
    private lateinit var linear:LinearLayoutManager
    private lateinit var _adapter : MoviesAdapter
    private var _listMovies = mutableListOf<ResponseResultModel>()
    private lateinit var _viewModel: PopularViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPopularBinding.inflate(inflater, container, false)
        val root: View = binding.root
        linear = GridLayoutManager(root.context,2)
        _adapter = MoviesAdapter(requireContext(),_listMovies)
        configurePropertiesRecyclerView()
        configureViewModel()
        return root
    }


    private fun showMoviesRecyclerView(listMovies : List<ResponseResultModel>){
        _listMovies.clear()
        _listMovies.addAll(listMovies)
        _adapter.notifyDataSetChanged()
    }

    private fun configureViewModel(){
        _viewModel = ViewModelProvider(
            this,
            PopularViewModel.PopularViewModelFactory(PopularMoviesRepository())
        ).get(PopularViewModel::class.java)

        _viewModel.getListPopularMovies().observe(viewLifecycleOwner,{
            showMoviesRecyclerView(it)
        })
    }

    private fun configurePropertiesRecyclerView(){
        binding.recyclerViewPopularMovies.apply {
            setHasFixedSize(true)
            layoutManager = linear
            adapter = _adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}