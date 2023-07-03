package com.example.myproject.albums

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.R
import com.example.myproject.databinding.ItemAlbumBinding

class AlbumsAdapter(val onFavouriteClicked: (position: Int) -> Unit) :
    RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {
    private val albums = mutableListOf<Album>()

    class AlbumsViewHolder(private val binding: ItemAlbumBinding, val onFavouriteClicked: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album) {
            binding.textAlbumTitle.text = album.title
            binding.textAlbumType.text = album.type
            binding.textAlbumYear.text = album.year.toString()
            binding.imageFavourite.setImageResource(
                if (album.isFavourite) R.drawable.ic_fav_filled else R.drawable.ic_fav_outline)
            binding.imageFavourite.setOnClickListener{//вызов пошаренный метод МА
                onFavouriteClicked.invoke(this.layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        val inFlater = LayoutInflater.from(parent.context)
        val binding = ItemAlbumBinding.inflate(inFlater, parent, false)
        return AlbumsViewHolder(binding, onFavouriteClicked)

    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        val album = albums[position]
        holder.bind(album)
//        Log.d("Tag", "OnBindViewholder, $position, $album")
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    fun setList(albums: List<Album>) {
        this.albums.addAll(albums)
    }

}


