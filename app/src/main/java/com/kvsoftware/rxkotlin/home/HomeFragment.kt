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
            buttonCreating.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToCreatingFragment()
                findNavController().navigate(action)
            }
            buttonTransforming.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToTransformingFragment()
                findNavController().navigate(action)
            }
            buttonFiltering.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToFilteringFragment()
                findNavController().navigate(action)
            }
            buttonCombining.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToCombiningFragment()
                findNavController().navigate(action)
            }
            buttonErrorHandling.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToErrorHandlingFragment()
                findNavController().navigate(action)
            }
            buttonUtility.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToUtilityFragment()
                findNavController().navigate(action)
            }
            buttonConditionalAndBoolean.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToConditionalAndBooleanFragment()
                findNavController().navigate(action)
            }
            buttonConnectable.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToConnectableFragment()
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