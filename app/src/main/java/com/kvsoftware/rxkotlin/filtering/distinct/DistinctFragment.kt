package com.kvsoftware.rxkotlin.filtering.distinct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentDistinctBinding

class DistinctFragment : Fragment() {

    private var fragmentDistinctBinding: FragmentDistinctBinding? = null

    private val viewModel: DistinctViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDistinctBinding.inflate(inflater, container, false)
        fragmentDistinctBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentDistinctBinding = null
        super.onDestroyView()
    }
}