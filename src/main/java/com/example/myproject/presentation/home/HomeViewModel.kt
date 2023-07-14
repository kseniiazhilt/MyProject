package com.example.myproject.presentation.home
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myproject.data.ArtistObject
import com.example.myproject.presentation.home.favArtists.Artist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private var artistName = ""
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _artist = MutableLiveData<Artist>()
    val artist: LiveData<Artist> = _artist

    fun onSearchTextChanged(newText: String) {
        artistName = newText
    }

    fun onButtonSearchClicked(){
       getArtistName()
    }

    private fun getArtistName() {
        viewModelScope.launch {
            try {
                val artist = ArtistObject.retrofitService.getArtistByName(artistName = "artistaccent:$artistName").artists[0]
                _status.value = "Success: ${artist} Artist name"
                _artist.value = artist
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}





















