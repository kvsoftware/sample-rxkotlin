package com.kvsoftware.rxkotlin.transforming.buffer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentBufferBinding

class BufferFragment : Fragment() {

    private var fragmentBufferBinding: FragmentBufferBinding? = null

    private val viewModel: BufferViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBufferBinding.inflate(inflater, container, false)
        fragmentBufferBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentBufferBinding = null
        super.onDestroyView()
    }
}