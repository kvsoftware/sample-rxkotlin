package com.kvsoftware.rxkotlin.creating.interval

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentIntervalBinding

class IntervalFragment : Fragment() {

    private var fragmentIntervalBinding: FragmentIntervalBinding? = null

    private val viewModel: IntervalViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentIntervalBinding.inflate(inflater, container, false)
        fragmentIntervalBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentIntervalBinding = null
        super.onDestroyView()
    }
}