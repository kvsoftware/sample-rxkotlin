package com.kvsoftware.rxkotlin.combining.combinelatest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentCombineLatestBinding

class CombineLatestFragment : Fragment() {

    private var fragmentCombineLatestBinding: FragmentCombineLatestBinding? = null

    private val viewModel: CombineLatestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCombineLatestBinding.inflate(inflater, container, false)
        fragmentCombineLatestBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentCombineLatestBinding = null
        super.onDestroyView()
    }
}