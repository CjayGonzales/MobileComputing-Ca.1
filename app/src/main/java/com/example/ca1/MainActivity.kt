package com.example.ca1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ca1.databinding.ActivityMainBinding
import com.example.ca1.models.Post

class MainActivity : AppCompatActivity() {
//    private lateinit var viewModel: MainViewModel
      private lateinit var binding: ActivityMainBinding
//    private lateinit var animeListAdapter: AnimeListAdapter
//    private val animePosts = mutableListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        viewModel.animations.observe(this, Observer { posts ->
//            Log.i("MainActivity", "Number of Posts: ${posts.size}" )
//            animePosts.addAll(posts)
//            animeListAdapter.notifyDataSetChanged()
//        })
//        viewModel.isLoading.observe(this, Observer { isLoading ->
//            Log.i("MainActivity", "is loading $isLoading")
//            //binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
//        })

//        TODO uncomment this to show problems

//        animeListAdapter = AnimeListAdapter(this, animePosts)
//        binding.navHostFragment.adapter = animeListAdapter
//        binding.navHostFragment.layoutManager = LinearLayoutManager(this)

//        binding.button.setOnClickListener{
//            viewModel.getPosts()
//        }


    }
}