package com.kvsoftware.rxkotlin.connectable.publish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentPublishBinding

class PublishFragment : Fragment() {

    private var fragmentPublishBinding: FragmentPublishBinding? = null

    private val viewModel: PublishViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPublishBinding.inflate(inflater, container, false)
        fragmentPublishBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentPublishBinding = null
        super.onDestroyView()
    }
}