package com.example.myproject.home
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.myproject.MainActivity
import com.example.myproject.R
import com.example.myproject.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
const val KEY = "KEY"

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
        }



    override fun onStart() {
        super.onStart()
        binding.btnAlb.setOnClickListener{
            (activity as MainActivity).findNavController(R.id.fragment_container).navigate(R.id.action_FirstFragment_to_AlbumsFragment)
        }

    }

    }






