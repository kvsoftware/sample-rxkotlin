package com.kvsoftware.rxkotlin.filtering.skiplast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentSkipBinding

class SkipLastFragment : Fragment() {

    private var fragmentSkipBinding: FragmentSkipBinding? = null

    private val lastViewModel: SkipLastViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSkipBinding.inflate(inflater, container, false)
        fragmentSkipBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lastViewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentSkipBinding = null
        super.onDestroyView()
    }
}