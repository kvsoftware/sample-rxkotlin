package com.kvsoftware.rxkotlin.conditionalandboolean.takeuntil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentTakeUntilBinding

class TakeUntilFragment : Fragment() {

    private var fragmentTakeUntilBinding: FragmentTakeUntilBinding? = null

    private val viewModel: TakeUntilViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTakeUntilBinding.inflate(inflater, container, false)
        fragmentTakeUntilBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentTakeUntilBinding = null
        super.onDestroyView()
    }
}