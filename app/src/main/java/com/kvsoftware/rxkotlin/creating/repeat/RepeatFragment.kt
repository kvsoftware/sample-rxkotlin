package com.kvsoftware.rxkotlin.creating.repeat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentRepeatBinding

class RepeatFragment : Fragment() {

    private var fragmentRepeatBinding: FragmentRepeatBinding? = null

    private val viewModel: RepeatViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRepeatBinding.inflate(inflater, container, false)
        fragmentRepeatBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentRepeatBinding = null
        super.onDestroyView()
    }
}