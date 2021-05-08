package com.kvsoftware.rxkotlin.creating.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentCreateBinding

class CreateFragment : Fragment() {

    private var fragmentCreateBinding: FragmentCreateBinding? = null

    private val viewModel: CreateViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCreateBinding.inflate(inflater, container, false)
        fragmentCreateBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentCreateBinding = null
        super.onDestroyView()
    }
}