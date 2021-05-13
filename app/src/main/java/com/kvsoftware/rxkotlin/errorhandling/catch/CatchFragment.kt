package com.kvsoftware.rxkotlin.errorhandling.catch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentCatchBinding

class CatchFragment : Fragment() {

    private var fragmentCatchBinding: FragmentCatchBinding? = null

    private val viewModel: CatchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCatchBinding.inflate(inflater, container, false)
        fragmentCatchBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentCatchBinding = null
        super.onDestroyView()
    }
}