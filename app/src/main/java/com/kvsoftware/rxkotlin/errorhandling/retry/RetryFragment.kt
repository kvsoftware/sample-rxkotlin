package com.kvsoftware.rxkotlin.errorhandling.retry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentRetryBinding

class RetryFragment : Fragment() {

    private var fragmentRetryBinding: FragmentRetryBinding? = null

    private val viewModel: RetryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRetryBinding.inflate(inflater, container, false)
        fragmentRetryBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentRetryBinding = null
        super.onDestroyView()
    }
}