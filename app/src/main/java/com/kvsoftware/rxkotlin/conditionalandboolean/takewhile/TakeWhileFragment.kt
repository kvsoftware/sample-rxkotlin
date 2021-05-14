package com.kvsoftware.rxkotlin.conditionalandboolean.takewhile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentTakeWhileBinding

class TakeWhileFragment : Fragment() {

    private var fragmentTakeWhileBinding: FragmentTakeWhileBinding? = null

    private val viewModel: TakeWhileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTakeWhileBinding.inflate(inflater, container, false)
        fragmentTakeWhileBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentTakeWhileBinding = null
        super.onDestroyView()
    }
}