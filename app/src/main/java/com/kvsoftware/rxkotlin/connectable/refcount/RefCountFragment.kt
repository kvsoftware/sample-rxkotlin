package com.kvsoftware.rxkotlin.connectable.refcount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentRefCountBinding

class RefCountFragment : Fragment() {

    private var fragmentRefCountBinding: FragmentRefCountBinding? = null

    private val viewModel: RefCountViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRefCountBinding.inflate(inflater, container, false)
        fragmentRefCountBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentRefCountBinding = null
        super.onDestroyView()
    }
}