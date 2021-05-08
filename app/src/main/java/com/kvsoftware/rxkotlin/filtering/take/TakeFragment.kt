package com.kvsoftware.rxkotlin.filtering.take

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentSkipBinding
import com.kvsoftware.rxkotlin.databinding.FragmentTakeBinding

class TakeFragment : Fragment() {

    private var fragmentTakeBinding: FragmentTakeBinding? = null

    private val viewModel: TakeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTakeBinding.inflate(inflater, container, false)
        fragmentTakeBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentTakeBinding = null
        super.onDestroyView()
    }
}