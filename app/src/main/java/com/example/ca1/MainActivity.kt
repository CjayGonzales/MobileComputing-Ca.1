package com.example.ca1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ca1.databinding.ActivityMainBinding
import com.example.ca1.models.Post

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // this starts the activity_main fragment
        setContentView(R.layout.activity_main)


    }
}