package com.kvsoftware.rxkotlin.conditionalandboolean.skipuntil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentSkipUntilBinding

class SkipUntilFragment : Fragment() {

    private var fragmentSkipUntilBinding: FragmentSkipUntilBinding? = null

    private val viewModel: SkipUntilViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSkipUntilBinding.inflate(inflater, container, false)
        fragmentSkipUntilBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentSkipUntilBinding = null
        super.onDestroyView()
    }
}