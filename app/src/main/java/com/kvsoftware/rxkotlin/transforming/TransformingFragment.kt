package com.kvsoftware.rxkotlin.transforming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentTransformingBinding

class TransformingFragment : Fragment() {

    private var fragmentTreatingBinding: FragmentTransformingBinding? = null

    private val viewModel: TransformingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTransformingBinding.inflate(inflater, container, false)
        fragmentTreatingBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentTreatingBinding = null
        super.onDestroyView()
    }
}