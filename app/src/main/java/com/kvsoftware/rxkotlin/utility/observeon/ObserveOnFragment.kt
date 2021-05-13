package com.kvsoftware.rxkotlin.utility.observeon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentObserveOnBinding

class ObserveOnFragment : Fragment() {

    private var fragmentObserveOnBinding: FragmentObserveOnBinding? = null

    private val onViewModel: ObserveOnViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentObserveOnBinding.inflate(inflater, container, false)
        fragmentObserveOnBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentObserveOnBinding = null
        super.onDestroyView()
    }
}