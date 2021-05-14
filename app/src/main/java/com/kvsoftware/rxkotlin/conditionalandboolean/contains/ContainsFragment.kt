package com.kvsoftware.rxkotlin.conditionalandboolean.contains

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentContainsBinding

class ContainsFragment : Fragment() {

    private var fragmentContainsBinding: FragmentContainsBinding? = null

    private val viewModel: ContainsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentContainsBinding.inflate(inflater, container, false)
        fragmentContainsBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentContainsBinding = null
        super.onDestroyView()
    }
}