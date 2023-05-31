package com.example.topnews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.topnews.databinding.FragmentTopNewsBinding
import com.example.topnews.presentation.viewModel.ViewModelFactory
import com.example.topnews.presentation.viewModel.WorldViewModel
import javax.inject.Inject


class TopNewsFragment : Fragment() {

    private var _binding: FragmentTopNewsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: WorldViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[WorldViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentTopNewsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.init()
    }



    companion object {

        @JvmStatic
        fun newInstance() =
            TopNewsFragment()
    }
}