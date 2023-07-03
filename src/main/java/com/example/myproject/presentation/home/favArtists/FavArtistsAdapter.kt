package com.example.myproject.presentation.home.favArtists

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.databinding.ItemArtistBinding


class FavArtistsAdapter() :
    RecyclerView.Adapter<FavArtistsAdapter.FavArtistsViewHolder>() {
    private val artists = mutableListOf<Artist>()

    class FavArtistsViewHolder(private val binding: ItemArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: Artist) {
            binding.nameArtist.text = artist.name
            binding.idArtist.text = artist.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavArtistsViewHolder {
        val inFlater = LayoutInflater.from(parent.context)
        val binding = ItemArtistBinding.inflate(inFlater, parent, false)
        return FavArtistsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: FavArtistsViewHolder, position: Int) {
        val artist = artists[position]
        holder.bind(artist)
        Log.d("Tag", "OnBindViewholder, $position, $artist")
    }

    override fun getItemCount(): Int {
        return artists.size
    }

    fun setList(albums: List<Artist>){
        this.artists.addAll(albums)
    }


}


