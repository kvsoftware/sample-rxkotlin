package com.kvsoftware.rxkotlin.creating

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentCreatingBinding

class CreatingFragment : Fragment() {

    private var fragmentCreatingBinding: FragmentCreatingBinding? = null

    private val viewModel: CreatingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCreatingBinding.inflate(inflater, container, false)
        fragmentCreatingBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentCreatingBinding = null
        super.onDestroyView()
    }
}