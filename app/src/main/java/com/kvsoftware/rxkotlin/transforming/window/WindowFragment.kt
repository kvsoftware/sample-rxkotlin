package com.kvsoftware.rxkotlin.transforming.window

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentWindowBinding

class WindowFragment : Fragment() {

    private var fragmentWindowBinding: FragmentWindowBinding? = null

    private val viewModel: WindowViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentWindowBinding.inflate(inflater, container, false)
        fragmentWindowBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentWindowBinding = null
        super.onDestroyView()
    }
}