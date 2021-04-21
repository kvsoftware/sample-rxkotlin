package com.kvsoftware.rxkotlin.transforming.flatmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentFlatMapBinding

class FlatMapFragment : Fragment() {

    private var fragmentFlatMapBinding: FragmentFlatMapBinding? = null

    private val viewModel: FlatMapViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFlatMapBinding.inflate(inflater, container, false)
        fragmentFlatMapBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentFlatMapBinding = null
        super.onDestroyView()
    }
}