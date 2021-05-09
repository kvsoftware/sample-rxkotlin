package com.kvsoftware.rxkotlin.utility.delay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentDelayBinding

class DelayFragment : Fragment() {

    private var fragmentDelayBinding: FragmentDelayBinding? = null

    private val viewModel: DelayViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDelayBinding.inflate(inflater, container, false)
        fragmentDelayBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentDelayBinding = null
        super.onDestroyView()
    }
}