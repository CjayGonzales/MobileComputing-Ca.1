package com.example.ca1

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ca1.data.Animation
import com.example.ca1.data.AnimeResponse
import com.example.ca1.databinding.ListItemBinding

// list adapter associates the data that the view holder views. Needed to ADAPT it

class AnimeListAdapter(val context: Context,
                       private val animeList: List<Animation>,
                       private val listener: ListItemListener):
    RecyclerView.Adapter<AnimeListAdapter.ViewHolder>() {

    val selectedAnime = arrayListOf<AnimeResponse>()

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){

        //binds it to the list_item.xml
            val binding = ListItemBinding.bind(itemView)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // inflater inflates the content
        val inflater = LayoutInflater.from(parent.context)

        // goes to the list_item fragment and inflates it
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = animeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anime = animeList[position]
        with(holder.binding){

            //binds the title of the anime to the card in the main fragment
            animeText.text = anime.titles?.en

            // allows for images to be placed
            Glide.with(context)
                .load(anime.cover_image)
                .into(animeImage)

            root.setOnClickListener{
                listener.onItemClick(anime)
            }
        }
    }

    interface ListItemListener{
        fun onItemClick(anime: Animation)
    }

}