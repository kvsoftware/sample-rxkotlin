package com.kvsoftware.rxkotlin.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kvsoftware.rxkotlin.databinding.FragmentBasicBinding

class BasicFragment : Fragment() {

    private var fragmentBasicBinding: FragmentBasicBinding? = null

    private val viewModel: BasicViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBasicBinding.inflate(inflater, container, false)
        fragmentBasicBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentBasicBinding = null
        super.onDestroyView()
    }
}