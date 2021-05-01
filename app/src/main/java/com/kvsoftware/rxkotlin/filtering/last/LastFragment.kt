package com.kvsoftware.rxkotlin.filtering.last

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentLastBinding

class LastFragment : Fragment() {

    private var fragmentLastBinding: FragmentLastBinding? = null

    private val viewModel: LastViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLastBinding.inflate(inflater, container, false)
        fragmentLastBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentLastBinding = null
        super.onDestroyView()
    }
}