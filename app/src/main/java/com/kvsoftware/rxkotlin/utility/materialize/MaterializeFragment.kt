package com.kvsoftware.rxkotlin.utility.materialize

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentMaterializeBinding

class MaterializeFragment : Fragment() {

    private var fragmentMaterializeBinding: FragmentMaterializeBinding? = null

    private val viewModel: MaterializeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMaterializeBinding.inflate(inflater, container, false)
        fragmentMaterializeBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentMaterializeBinding = null
        super.onDestroyView()
    }
}