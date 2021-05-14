package com.kvsoftware.rxkotlin.conditionalandboolean.defaultifempty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentDefaultIfEmptyBinding

class DefaultIfEmptyFragment : Fragment() {

    private var fragmentDefaultIfEmptyBinding: FragmentDefaultIfEmptyBinding? = null

    private val viewModel: DefaultIfEmptyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDefaultIfEmptyBinding.inflate(inflater, container, false)
        fragmentDefaultIfEmptyBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentDefaultIfEmptyBinding = null
        super.onDestroyView()
    }
}