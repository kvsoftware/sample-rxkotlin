package com.kvsoftware.rxkotlin.conditionalandboolean.amb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentAmbBinding

class AmbFragment : Fragment() {

    private var fragmentAmbBinding: FragmentAmbBinding? = null

    private val viewModel: AmbViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAmbBinding.inflate(inflater, container, false)
        fragmentAmbBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentAmbBinding = null
        super.onDestroyView()
    }
}