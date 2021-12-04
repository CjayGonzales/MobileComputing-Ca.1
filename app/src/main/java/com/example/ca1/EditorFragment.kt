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
            // 'it' is similar to 'this' in Java (there are small differences)
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_check)
        }
        setHasOptionsMenu(true)

        // bind 'binding' to the editor fragment layout
        binding = EditorFragmentBinding.inflate(inflater, container, false)

        // args.plantId is the ID of the argument you added in the nav_graph (you added it to the editor fragment)
        binding.titles.text = args.anime.titles?.en
        binding.descriptions.text = args.anime.descriptions?.en

// TODO add the rest of these
//        binding.seasonYear.setText(args.anime.seasonYear)
//        binding.episodeCount.setText(args.anime.episodeCount)
//        binding.episodeDuration.setText(args.anime.episodeDuration)
//        binding.trailerUrl.setText(args.anime.trailerUrl)
//        binding.genres.setText(args.anime.genres)
//        binding.score.setText(args.anime.score)

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
                    // you write the code for saveAndReturn - later this will need to save to the Database
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditorViewModel::class.java)
    }

}