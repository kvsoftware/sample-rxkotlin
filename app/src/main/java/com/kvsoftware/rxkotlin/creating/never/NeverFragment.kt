package com.kvsoftware.rxkotlin.creating.never

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentNeverBinding

class NeverFragment : Fragment() {

    private var fragmentNeverBinding: FragmentNeverBinding? = null

    private val viewModel: NeverViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNeverBinding.inflate(inflater, container, false)
        fragmentNeverBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentNeverBinding = null
        super.onDestroyView()
    }
}