package com.kvsoftware.rxkotlin.utility

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kvsoftware.rxkotlin.databinding.FragmentUtilityBinding

class UtilityFragment : Fragment() {

    private var fragmentUtilityBinding: FragmentUtilityBinding? = null

    private val viewModel: UtilityViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentUtilityBinding.inflate(inflater, container, false)
        fragmentUtilityBinding = binding
        binding.apply {
            buttonDelay.setOnClickListener {
                val action =
                    UtilityFragmentDirections.actionUtilityFragmentToDelayFragment()
                findNavController().navigate(action)
            }
            buttonDo.setOnClickListener {
                val action =
                    UtilityFragmentDirections.actionUtilityFragmentToDoFragment()
                findNavController().navigate(action)
            }
            buttonMaterialize.setOnClickListener {
                val action =
                    UtilityFragmentDirections.actionUtilityFragmentToMaterializeFragment()
                findNavController().navigate(action)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentUtilityBinding = null
        super.onDestroyView()
    }
}