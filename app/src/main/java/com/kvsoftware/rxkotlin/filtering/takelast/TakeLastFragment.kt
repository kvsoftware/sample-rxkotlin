package com.kvsoftware.rxkotlin.filtering.takelast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentSkipBinding
import com.kvsoftware.rxkotlin.databinding.FragmentTakeLastBinding

class TakeLastFragment : Fragment() {

    private var fragmentTakeLastBinding: FragmentTakeLastBinding? = null

    private val lastViewModel: TakeLastViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTakeLastBinding.inflate(inflater, container, false)
        fragmentTakeLastBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lastViewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentTakeLastBinding = null
        super.onDestroyView()
    }
}