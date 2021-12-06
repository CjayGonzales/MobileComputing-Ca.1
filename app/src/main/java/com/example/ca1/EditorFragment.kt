package com.example.ca1

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.ca1.data.FavouriteAnime
import com.example.ca1.databinding.EditorFragmentBinding

class EditorFragment : Fragment() {

    private val args: EditorFragmentArgs by navArgs()
    private lateinit var binding: EditorFragmentBinding
    private lateinit var viewModel: EditorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.let {
            // 'it' is similar to 'this' in Java
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_check)
        }
        setHasOptionsMenu(true)

        // bind 'binding' to the editor fragment layout
        binding = EditorFragmentBinding.inflate(inflater, container, false)

        // args.plantId is the ID of the argument you added in the nav_graph (you bind it to the editor fragment)
        binding.titles.text = args.anime.titles?.en
        binding.descriptions.text = args.anime.descriptions?.en
        binding.seasonYear.text = args.anime.season_year.toString()
        binding.episodeCount.text = args.anime.episodes_count.toString()
        binding.episodeDuration.text = args.anime.episode_duration.toString()
        binding.trailerUrl.text = args.anime.trailer_url
        binding.score.text = args.anime.score.toString()

        //glide images - will allow us to display images in our program ////////////////////////////

        Glide.with(this)
            .load(args.anime.cover_image)
            .into(binding.animeImage)

        //This will allow us to save to a local storage/////////////////////////////////////////////
        viewModel = ViewModelProvider(this).get(EditorViewModel::class.java)
        viewModel.currentFavourite.observe(viewLifecycleOwner, Observer {
            binding.myNotes.setText(it.myNotes)
        })

        viewModel.getFavourite(args.anime.id)

        ////////////////////////////////////////////////////////////////////////////////////////////
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true){
                override fun handleOnBackPressed(){
                    // this is needed to save to the Database
                    saveAndReturn()
                }
            }
        )
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // When the home button is clicked, save changes then return to the MainFragment, which is the List
            android.R.id.home -> saveAndReturn()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveAndReturn() : Boolean{
        viewModel.saveFavourite(FavouriteAnime(args.anime.id, binding.myNotes.text.toString()))
        findNavController().navigateUp()
        return true
    }

    //called when the activity is created
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditorViewModel::class.java)
    }

}