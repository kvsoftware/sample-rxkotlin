package com.kvsoftware.rxkotlin.connectable.replay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentReplayBinding

class ReplayFragment : Fragment() {

    private var fragmentReplayBinding: FragmentReplayBinding? = null

    private val viewModel: ReplayViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding = FragmentReplayBinding.inflate(inflater, container, false)
        fragmentReplayBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentReplayBinding = null
        super.onDestroyView()
    }
}