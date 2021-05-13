package com.kvsoftware.rxkotlin.utility.timeout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentTimeOutBinding

class TimeOutFragment : Fragment() {

    private var fragmentTimeOutBinding: FragmentTimeOutBinding? = null

    private val viewModel: TimeOutViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTimeOutBinding.inflate(inflater, container, false)
        fragmentTimeOutBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentTimeOutBinding = null
        super.onDestroyView()
    }
}