package com.kvsoftware.rxkotlin.creating.just

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentJustBinding

class JustFragment : Fragment() {

    private var fragmentJustBinding: FragmentJustBinding? = null

    private val viewModel: JustViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentJustBinding.inflate(inflater, container, false)
        fragmentJustBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentJustBinding = null
        super.onDestroyView()
    }
}