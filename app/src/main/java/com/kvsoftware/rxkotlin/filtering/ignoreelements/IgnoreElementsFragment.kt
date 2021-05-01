package com.kvsoftware.rxkotlin.filtering.ignoreelements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentIgnoreElementsBinding

class IgnoreElementsFragment : Fragment() {

    private var fragmentIgnoreElementsBinding: FragmentIgnoreElementsBinding? = null

    private val viewModel: IgnoreElementsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentIgnoreElementsBinding.inflate(inflater, container, false)
        fragmentIgnoreElementsBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentIgnoreElementsBinding = null
        super.onDestroyView()
    }
}