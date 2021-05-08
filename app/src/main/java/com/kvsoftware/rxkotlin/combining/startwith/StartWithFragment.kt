package com.kvsoftware.rxkotlin.combining.startwith

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentStartWithBinding

class StartWithFragment : Fragment() {

    private var fragmentStartWithBinding: FragmentStartWithBinding? = null

    private val viewModel: StartWithViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentStartWithBinding.inflate(inflater, container, false)
        fragmentStartWithBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentStartWithBinding = null
        super.onDestroyView()
    }
}