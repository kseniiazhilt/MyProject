package com.example.myproject.presentation.home
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myproject.data.ArtistObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private var artistName = ""
    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

    private fun getArtistName() {
        viewModelScope.launch {
            try {
                val listResult = ArtistObject.retrofitService.getArtistByName(artistName = "artistaccent:$artistName")
                _status.value = "Success: ${listResult.artists} Artist name"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

    fun onSearchTextChanged(newText: String) {
        artistName = newText
    }

    fun onButtonSearchClicked(){
       getArtistName()
    }
}





















