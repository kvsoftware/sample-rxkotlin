package com.kvsoftware.rxkotlin.filtering.elementat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentElementAtBinding

class ElementAtFragment : Fragment() {

    private var fragmentElementAtBinding: FragmentElementAtBinding? = null

    private val viewModel: ElementAtViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentElementAtBinding.inflate(inflater, container, false)
        fragmentElementAtBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentElementAtBinding = null
        super.onDestroyView()
    }
}