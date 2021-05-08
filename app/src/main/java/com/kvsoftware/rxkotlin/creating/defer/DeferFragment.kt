package com.kvsoftware.rxkotlin.creating.defer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentDeferBinding

class DeferFragment : Fragment() {

    private var fragmentDeferBinding: FragmentDeferBinding? = null

    private val viewModel: DeferViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDeferBinding.inflate(inflater, container, false)
        fragmentDeferBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentDeferBinding = null
        super.onDestroyView()
    }
}