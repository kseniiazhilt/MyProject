package com.example.myproject.albums

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject.MainActivity
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = activity as MainActivity//ссылка на МА
        val adapter = AlbumsAdapter(mainActivity::onFavouriteClicked)//шарим метод МА
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerAlbums.layoutManager = layoutManager
        binding.recyclerAlbums.adapter = adapter

        adapter.setList(mainActivity.allAlbums)
    }

    fun notifyAlbumsChanged(position: Int){
        binding.recyclerAlbums.adapter?.notifyItemChanged(position)//сообщаем ресайклеру, что данные обновились и их нужно перерисовать
    }

    }











//private fun generateFakeValues(): List<Album>{
//    val values = mutableListOf<Album>()
//    val album = Album(title = "Name", type = "String", year = 0, image = null)
//    for (i in 0..100) {
//        values.add(album)
//    }
//    return values
//}