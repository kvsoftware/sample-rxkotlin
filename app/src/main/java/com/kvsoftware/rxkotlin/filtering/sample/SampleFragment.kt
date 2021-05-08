package com.kvsoftware.rxkotlin.filtering.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentSampleBinding

class SampleFragment : Fragment() {

    private var fragmentSampleBinding: FragmentSampleBinding? = null

    private val viewModel: SampleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSampleBinding.inflate(inflater, container, false)
        fragmentSampleBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentSampleBinding = null
        super.onDestroyView()
    }
}