package com.example.myproject.presentation.home.favArtists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject.databinding.FragmentFavouriteArtistsBinding


class FavouriteArtistsFragment : Fragment() {
    lateinit var binding: FragmentFavouriteArtistsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteArtistsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = FavArtistsAdapter()
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerFavArtists.layoutManager = layoutManager
        binding.recyclerFavArtists.adapter = adapter
        adapter.setList(generateFakeValues())
    }

    private fun generateFakeValues(): List<Artist>{
        val values = mutableListOf<Artist>()
        val artist = Artist(name = "Artist Name", id = "id")
        for (i in 0..100) {
            values.add(artist)
        }
        return values
    }



}