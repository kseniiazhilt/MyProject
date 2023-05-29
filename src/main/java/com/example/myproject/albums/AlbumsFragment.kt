package com.example.myproject.albums

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myproject.MainActivity
import com.example.myproject.R
import com.example.myproject.databinding.FragmentAlbumsBinding

class AlbumsFragment : Fragment() {
    lateinit var binding: FragmentAlbumsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnFav.setOnClickListener{
            (activity as MainActivity).findNavController(R.id.fragment_container).navigate(R.id.action_albumsFragment_to_favouriteArtistsFragment2)
        }
    }

}
