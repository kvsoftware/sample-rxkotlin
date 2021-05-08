package com.kvsoftware.rxkotlin.creating.from

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentFromBinding

class FromFragment : Fragment() {

    private var fragmentFromBinding: FragmentFromBinding? = null

    private val viewModel: FromViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFromBinding.inflate(inflater, container, false)
        fragmentFromBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentFromBinding = null
        super.onDestroyView()
    }
}