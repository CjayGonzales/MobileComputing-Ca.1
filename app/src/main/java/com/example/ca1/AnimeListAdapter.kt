package com.example.ca1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ca1.data.AnimeEntity
import com.example.ca1.databinding.ListItemBinding

class AnimeListAdapter(private val animeList: List<AnimeEntity>) :
    RecyclerView.Adapter<AnimeListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
            val binding = ListItemBinding.bind(itemView)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anime = animeList[position]
        with(holder.binding){
            animeText.text = anime.titles
        }
    }

    override fun getItemCount() = animeList.size

}