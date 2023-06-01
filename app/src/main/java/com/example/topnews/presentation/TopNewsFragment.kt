package com.example.topnews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.topnews.App
import com.example.topnews.databinding.FragmentTopNewsBinding
import com.example.topnews.presentation.adapter.WorldNewsAdapter
import com.example.topnews.presentation.appState.AppState
import com.example.topnews.presentation.viewModel.WorldViewModel
import javax.inject.Inject

class TopNewsFragment : Fragment() {

    private var _binding: FragmentTopNewsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: WorldViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[WorldViewModel::class.java]
    }

    private lateinit var adapter: WorldNewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTopNewsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listItem.observe(viewLifecycleOwner, Observer {
            appState(it)
        })

        viewModel.init()

        binding.frameLoad.visibility = View.VISIBLE
    }

    private fun appState(it: AppState) {

        when (it) {
            is AppState.OnSuccess -> {

                adapter = WorldNewsAdapter(it.results).apply {
                    App.instance.appComponent.inject(this)
                }
                binding.recyclerView.adapter = adapter
                binding.frameLoad.visibility = View.GONE
            }

            is AppState.Error -> {
                Toast.makeText(requireActivity(), it.error, Toast.LENGTH_SHORT).show()
            }

            is AppState.Loading -> {
                binding.frameLoad.visibility = View.VISIBLE
            }
        }
    }
}


