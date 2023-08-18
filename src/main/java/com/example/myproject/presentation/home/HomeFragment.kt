package com.example.myproject.presentation.home
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myproject.R
import com.example.myproject.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    companion object{
        val KEY_ARTIST = "artist"
    }

    lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            editTextSearch.doAfterTextChanged {
                viewModel.onSearchTextChanged(it.toString())
            }
            buttonSearch.setOnClickListener {
                viewModel.onButtonSearchClicked()
            }

        }

        viewModel.artist.observe(viewLifecycleOwner){
            val pair = Pair(KEY_ARTIST, it)
            findNavController().navigate(R.id.AlbumsFragment, bundleOf(pair))
        }
    }


}








