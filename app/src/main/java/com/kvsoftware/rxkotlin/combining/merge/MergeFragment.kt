package com.kvsoftware.rxkotlin.combining.merge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentMergeBinding

class MergeFragment : Fragment() {

    private var fragmentMergeBinding: FragmentMergeBinding? = null

    private val viewModel: MergeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMergeBinding.inflate(inflater, container, false)
        fragmentMergeBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentMergeBinding = null
        super.onDestroyView()
    }
}