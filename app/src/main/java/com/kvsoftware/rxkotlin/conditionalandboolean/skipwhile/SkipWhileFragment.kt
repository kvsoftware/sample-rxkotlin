package com.kvsoftware.rxkotlin.conditionalandboolean.skipwhile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentSkipWhileBinding

class SkipWhileFragment : Fragment() {

    private var fragmentSkipWhileBinding: FragmentSkipWhileBinding? = null

    private val viewModel: SkipWhileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSkipWhileBinding.inflate(inflater, container, false)
        fragmentSkipWhileBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentSkipWhileBinding = null
        super.onDestroyView()
    }
}