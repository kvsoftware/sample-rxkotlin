package com.kvsoftware.rxkotlin.creating.empty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentEmptyBinding

class EmptyFragment : Fragment() {

    private var fragmentEmptyBinding: FragmentEmptyBinding? = null

    private val viewModel: EmptyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentEmptyBinding.inflate(inflater, container, false)
        fragmentEmptyBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentEmptyBinding = null
        super.onDestroyView()
    }
}