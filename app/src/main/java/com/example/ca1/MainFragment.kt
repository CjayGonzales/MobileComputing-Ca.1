package com.example.ca1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ca1.data.Animation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ca1.data.AnimeResponse

import com.example.ca1.databinding.FragmentMainBinding

class MainFragment : Fragment(),
    AnimeListAdapter.ListItemListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: AnimeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity)
            .supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(true)


        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //viewModel.getPosts()
        //references the object multiple times
        with(binding.recyclerView){
            setHasFixedSize(true)

            //creates a divider item
            val divider = DividerItemDecoration(
                context, LinearLayoutManager(context).orientation
            )
            addItemDecoration(divider)
        }

        viewModel.anime.observe(viewLifecycleOwner, Observer{
            //Log.i("note Logging", it.toString())
            adapter = AnimeListAdapter(requireContext(),it, this@MainFragment)
            binding.recyclerView.adapter = adapter
            //binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        })

        return binding.root
    }

    override fun onItemClick(anime: Animation){
        //Log.i(TAG, "onItemClick : Received Anime name ${anime.titles}")
        val action = MainFragmentDirections.actionMainFragmentToEditorFragment(anime)
        findNavController().navigate(action)
    }

}