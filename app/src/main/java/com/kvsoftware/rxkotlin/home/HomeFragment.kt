package com.kvsoftware.rxkotlin.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kvsoftware.rxkotlin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var fragmentHomeBinding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        fragmentHomeBinding = binding
        binding.apply {
            buttonBasic.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToCreatingFragment()
                findNavController().navigate(action)
            }
            buttonMap.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToMapFragment()
                findNavController().navigate(action)
            }
            buttonDebounce.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToDebounceFragment()
                findNavController().navigate(action)
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        fragmentHomeBinding = null
        super.onDestroyView()
    }
}