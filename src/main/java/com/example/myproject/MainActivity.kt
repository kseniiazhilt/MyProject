package com.example.myproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.example.myproject.albums.Album
import com.example.myproject.albums.AlbumsFragment
import com.example.myproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.FieldPosition

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val allAlbums = mutableListOf<Album>()

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        allAlbums.addAll(generateFakeValues())//генерация данныж

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNav
            .setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun onFavouriteClicked(position: Int) {
        Log.d("KSENIIA", "On Favourite clicked by position $position")
        allAlbums[position].isFavourite = !allAlbums[position].isFavourite //меняем значение на обратное
        (supportFragmentManager.fragments.first() as NavHostFragment).childFragmentManager.fragments.first()?.let {//ищем ссылку на Албомс Фрагмент
            (it as AlbumsFragment).notifyAlbumsChanged(position)//вызываем мктод Фрагмента благодаря найденной ссылке
        }
    }

    private fun generateFakeValues(): List<Album> {
        val values = mutableListOf<Album>()
        val album = Album(title = "Name", type = "String", year = 0, image = null)
        for (i in 0..100) {
            values.add(album)
        }
        return values
    }

}


//        super.onCreate(savedInstanceState)
//        setFragmentResultListener() { key, bundle ->
//            val result = bundle.getString()
//        }
//
//        val nameObserver = Observer<String> { newName ->
//            editTextSearch.text = newName
//        }
//
//        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//        model.currentName.observe(this, nameObserver)