package com.kvsoftware.rxkotlin.filtering

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kvsoftware.rxkotlin.databinding.FragmentFilteringBinding

class FilteringFragment : Fragment() {

    private var fragmentFilteringBinding: FragmentFilteringBinding? = null

    private val viewModel: FilteringViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFilteringBinding.inflate(inflater, container, false)
        fragmentFilteringBinding = binding
        binding.apply {
            buttonDebounce.setOnClickListener {
                val action = FilteringFragmentDirections.actionTransformingFragmentToDebounceFragment()
                findNavController().navigate(action)
            }
            buttonDistinct.setOnClickListener {
                val action = FilteringFragmentDirections.actionTransformingFragmentToDistinctFragment()
                findNavController().navigate(action)
            }
            buttonElementAt.setOnClickListener {
                val action = FilteringFragmentDirections.actionTransformingFragmentToElementAtFragment()
                findNavController().navigate(action)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentFilteringBinding = null
        super.onDestroyView()
    }

}