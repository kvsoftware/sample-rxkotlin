package com.kvsoftware.rxkotlin.transforming.groupby

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentGroupByBinding

class GroupByFragment : Fragment() {

    private var fragmentGroupByBinding: FragmentGroupByBinding? = null

    private val viewModel: GroupByViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGroupByBinding.inflate(inflater, container, false)
        fragmentGroupByBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentGroupByBinding = null
        super.onDestroyView()
    }
}