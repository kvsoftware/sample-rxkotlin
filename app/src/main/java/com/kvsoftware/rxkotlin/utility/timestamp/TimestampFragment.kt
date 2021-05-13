package com.kvsoftware.rxkotlin.utility.timestamp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentTimestampBinding

class TimestampFragment : Fragment() {

    private var fragmentTimestampBinding: FragmentTimestampBinding? = null

    private val viewModel: TimestampViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTimestampBinding.inflate(inflater, container, false)
        fragmentTimestampBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentTimestampBinding = null
        super.onDestroyView()
    }
}