package com.example.desafio_android_stant.upcoming.view.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio_android_stant.data.adapters.PopularMoviesAdapter
import com.example.desafio_android_stant.data.models.ResponseResultModel
import com.example.desafio_android_stant.databinding.FragmentUpcomingBinding
import com.example.desafio_android_stant.toprated.repository.TopRatedMoviesRepository
import com.example.desafio_android_stant.toprated.viewmodel.TopRatedViewModel
import com.example.desafio_android_stant.upcoming.repository.UpComingMoviesRepository
import com.example.desafio_android_stant.upcoming.viewmodel.UpComingViewModel

class UpComingFragment : Fragment() {

    private var _binding: FragmentUpcomingBinding? = null

    private val binding get() = _binding!!
    private lateinit var linear: LinearLayoutManager
    private lateinit var _adapter : PopularMoviesAdapter
    private var _listMovies = mutableListOf<ResponseResultModel>()
    private lateinit var _viewModel: UpComingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUpcomingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        linear = GridLayoutManager(root.context,2)
        _adapter = PopularMoviesAdapter(requireContext(),_listMovies)
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
            UpComingViewModel.UpComingViewModelFactory(UpComingMoviesRepository())
        ).get(UpComingViewModel::class.java)

        _viewModel.getListUpComingMovies().observe(viewLifecycleOwner,{
            showMoviesRecyclerView(it)
        })
    }

    private fun configurePropertiesRecyclerView(){
        binding.recyclerViewUpComingMovies.apply {
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