package com.example.kotlin.myapplication.framework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.myapplication.R
import com.example.kotlin.myapplication.data.network.model.MovieBase
import com.example.kotlin.myapplication.databinding.FragmentMovieBinding
import com.example.kotlin.myapplication.framework.adapters.MovieAdapter
import com.example.kotlin.myapplication.framework.viewmodel.MovieViewModel

class MovieFragment : Fragment() {
    private var _binding: FragmentMovieBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: MovieViewModel

    private lateinit var recyclerView: RecyclerView
    private val adapter: MovieAdapter = MovieAdapter()
    private lateinit var data: ArrayList<MovieBase>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        val root: View = binding.root

        data = ArrayList()

        initializeComponents(root)
        initializeObservers()
        viewModel.getMovieList()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeComponents(root: View) {
        recyclerView = root.findViewById(R.id.RVMovie)
    }

    private fun initializeObservers() {
        viewModel.movieObjectLiveData.observe(viewLifecycleOwner) { movieObject ->
            setUpRecyclerView(movieObject.results)
        }
    }

    private fun setUpRecyclerView(dataForList: ArrayList<MovieBase>) {
        recyclerView.setHasFixedSize(true)
        /*val linearLayoutManager = LinearLayoutManager(
            requireContext(),        LinearLayoutManager.VERTICAL,        false)*/
        val gridLayoutManager = GridLayoutManager(
            requireContext(),
            2,
            GridLayoutManager.VERTICAL,
            false
        )
        recyclerView.layoutManager = gridLayoutManager
        adapter.MovieAdapter(dataForList, requireContext())
        recyclerView.adapter = adapter
    }
}