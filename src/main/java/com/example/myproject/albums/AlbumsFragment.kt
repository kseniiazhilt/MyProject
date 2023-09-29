package com.example.myproject.albums

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject.databinding.FragmentAlbumsBinding
import com.example.myproject.presentation.home.HomeFragment
import com.example.myproject.presentation.home.favArtists.Artist

class AlbumsFragment : Fragment() {
    lateinit var binding: FragmentAlbumsBinding
    private val albumsViewModel: AlbumsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val artist = arguments?.get(HomeFragment.KEY_ARTIST) as? Artist

        val adapter = AlbumsAdapter(albumsViewModel::onAlbumClicked)//шарим метод МА
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerAlbums.layoutManager = layoutManager
        binding.recyclerAlbums.adapter = adapter
        adapter.setList(generateFakeValues())
        albumsViewModel.getAlbums(artist)
        albumsViewModel.albums.observe(viewLifecycleOwner){
            adapter.setList(it)
        }
    }

    fun notifyAlbumsChanged(position: Int) {
        binding.recyclerAlbums.adapter?.notifyItemChanged(position)//сообщаем ресайклеру, что данные обновились и их нужно перерисовать
    }

    private fun generateFakeValues(): List<Album>{
        val values = mutableListOf<Album>()
        val album = Album(title = "Album Name", type = "Album type", year = "")
        for (i in 0..100) {
            values.add(album)
        }
        return values
    }

}


