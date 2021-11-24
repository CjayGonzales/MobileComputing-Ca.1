package com.example.ca1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ca1.data.Animation
import com.example.ca1.data.AnimeResponse
import com.example.ca1.databinding.ListItemBinding

class AnimeListAdapter(private val animeList: List<Animation>,
                       private val listener: ListItemListener) :
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

    override fun getItemCount() = animeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anime = animeList[position]
        with(holder.binding){
            animeText.text = anime.titles.enTitle
            root.setOnClickListener{
                listener.onItemClick(anime)
            }
        }
    }

    interface ListItemListener{
        fun onItemClick(anime: Animation)
    }

}