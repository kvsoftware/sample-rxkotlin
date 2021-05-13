package com.kvsoftware.rxkotlin.utility.serialize

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentSubscribeOnBinding

class SubscribeOnFragment : Fragment() {

    private var fragmentSubscribeOnBinding: FragmentSubscribeOnBinding? = null

    private val viewModel: SubscribeOnViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSubscribeOnBinding.inflate(inflater, container, false)
        fragmentSubscribeOnBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentSubscribeOnBinding = null
        super.onDestroyView()
    }
}