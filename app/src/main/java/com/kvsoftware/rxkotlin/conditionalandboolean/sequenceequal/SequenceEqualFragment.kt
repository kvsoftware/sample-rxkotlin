package com.kvsoftware.rxkotlin.conditionalandboolean.sequenceequal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentSequenceEqualBinding

class SequenceEqualFragment : Fragment() {

    private var fragmentSequenceEqualBinding: FragmentSequenceEqualBinding? = null

    private val viewModel: SequenceEqualViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSequenceEqualBinding.inflate(inflater, container, false)
        fragmentSequenceEqualBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentSequenceEqualBinding = null
        super.onDestroyView()
    }
}