package com.kvsoftware.rxkotlin.creating.range

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentRangeBinding

class RangeFragment : Fragment() {

    private var fragmentRangeBinding: FragmentRangeBinding? = null

    private val viewModel: RangeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRangeBinding.inflate(inflater, container, false)
        fragmentRangeBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentRangeBinding = null
        super.onDestroyView()
    }
}