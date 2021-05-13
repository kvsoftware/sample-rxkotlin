package com.kvsoftware.rxkotlin.utility.`do`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentDoBinding

class DoFragment : Fragment() {

    private var fragmentDoBinding: FragmentDoBinding? = null

    private val viewModel: DoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDoBinding.inflate(inflater, container, false)
        fragmentDoBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentDoBinding = null
        super.onDestroyView()
    }
}