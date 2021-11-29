package com.example.ca1

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ca1.data.Animation
import com.example.ca1.data.AnimeResponse
import com.example.ca1.databinding.ListItemBinding

class AnimeListAdapter(private val animeList: List<Animation>,
                       private val listener: ListItemListener):
    RecyclerView.Adapter<AnimeListAdapter.ViewHolder>() {



    val selectedAnime = arrayListOf<AnimeResponse>()

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){

        //binds it to the list_item.xml
            val binding = ListItemBinding.bind(itemView)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = animeList.size

    // i tried to logcat it but it doesn't display the variable to the console

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anime = animeList[position]
        with(holder.binding){
            animeText.text = anime.titles?.enTitle



            //Log.i("MainViewModel", "${ this.animeText }")
            root.setOnClickListener{
                listener.onItemClick(anime)
            }
        }
    }

    interface ListItemListener{
        fun onItemClick(anime: Animation)
    }

}