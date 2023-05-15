package com.example.myproject

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myproject.databinding.ActivityMainBinding
const val TAG = "X"

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.toolbar)
//
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onStart() {
        Log.d(TAG, "MainActivity BEFORE_ON_START")
        super.onStart()
        Log.d(TAG, "MainActivity ON_START")
    }

    override fun onResume() {
        Log.d(TAG, "MainActivity BEFORE_ON_RESUME")
        super.onResume()
        Log.d(TAG, "MainActivity ON_RESUME")
    }

    override fun onPause() {
        Log.d(TAG, "MainActivity BEFORE_ON_PAUSE")
        super.onPause()
        Log.d(TAG, "MainActivity ON_PAUSE")
    }

    override fun onStop() {
        Log.d(TAG, "MainActivity BEFORE_ON_STOP")
        super.onStop()
        Log.d(TAG, "MainActivity ON_STOP")
    }

    override fun onDestroy() {
        Log.d(TAG, "MainActivity BEFORE_ON_DESTROY")
        super.onDestroy()
        Log.d(TAG, "MainActivity ON_DESTROY")
    }
}