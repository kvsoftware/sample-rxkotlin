package com.kvsoftware.rxkotlin.utility.timeinterval

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentTimeIntervalBinding

class TimeIntervalFragment : Fragment() {

    private var fragmentTimeIntervalBinding: FragmentTimeIntervalBinding? = null

    private val viewModel: TimeIntervalViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTimeIntervalBinding.inflate(inflater, container, false)
        fragmentTimeIntervalBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentTimeIntervalBinding = null
        super.onDestroyView()
    }
}