package com.example.myproject.albums

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myproject.data.AlbumsObject
import com.example.myproject.presentation.home.favArtists.Artist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor() : ViewModel() {
    private var albumTytle = ""
    private val _statusAlbum = MutableLiveData<String>()
    val statusAlbum: LiveData<String> = _statusAlbum

    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> = _albums

    fun onSearchTextChanged(newText: String) {
        albumTytle = newText
    }

    fun onAlbumClicked(album: Album) {
    }

      fun getAlbums(artist: Artist?) {
        artist?.let {
            viewModelScope.launch(Dispatchers.IO) {
//                try {
                    val albumsResponse = AlbumsObject.retrofitService.getArtistAlbum("arid:${artist.id}")
                    _statusAlbum.postValue("Success: ${this@AlbumsViewModel.albums} Album tytle")
                    Log.d("TAG", albumsResponse.toString())
                    _albums.postValue(albumsResponse.albums)
//                }
//                catch (e: Exception){
//                    Log.d("TAG", e.message.toString())
//                }
            }
        }
    }



}