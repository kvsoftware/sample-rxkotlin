package com.kvsoftware.rxkotlin.transforming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kvsoftware.rxkotlin.databinding.FragmentTransformingBinding
import com.kvsoftware.rxkotlin.home.HomeFragmentDirections

class TransformingFragment : Fragment() {

    private var fragmentTreatingBinding: FragmentTransformingBinding? = null

    private val viewModel: TransformingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTransformingBinding.inflate(inflater, container, false)
        fragmentTreatingBinding = binding
        binding.apply {
            buttonBuffer.setOnClickListener {
                val action = TransformingFragmentDirections.actionTransformingFragmentToBufferFragment()
                findNavController().navigate(action)
            }
            buttonFlatMap.setOnClickListener {
                val action = TransformingFragmentDirections.actionTransformingFragmentToFlatMapFragment()
                findNavController().navigate(action)
            }
            buttonGroupBy.setOnClickListener {
                val action = TransformingFragmentDirections.actionTransformingFragmentToGroupByFragment()
                findNavController().navigate(action)
            }
            buttonMap.setOnClickListener {
                val action = TransformingFragmentDirections.actionTransformingFragmentToMapFragment()
                findNavController().navigate(action)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        fragmentTreatingBinding = null
        super.onDestroyView()
    }
}