package com.kvsoftware.rxkotlin.conditionalandboolean

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kvsoftware.rxkotlin.databinding.FragmentConditionalAndBooleanBinding

class ConditionalAndBooleanFragment : Fragment() {

    private var fragmentConditionalAndBooleanBinding: FragmentConditionalAndBooleanBinding? = null

    private val viewModel: ConditionalAndBooleanViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentConditionalAndBooleanBinding.inflate(inflater, container, false)
        fragmentConditionalAndBooleanBinding = binding
        binding.apply {
            buttonAll.setOnClickListener {
                val action =
                    ConditionalAndBooleanFragmentDirections.actionConditionalAndBooleanFragmentToAllFragment()
                findNavController().navigate(action)
            }
            buttonAmb.setOnClickListener {
                val action =
                    ConditionalAndBooleanFragmentDirections.actionConditionalAndBooleanFragmentToAmbFragment()
                findNavController().navigate(action)
            }
            buttonContains.setOnClickListener {
                val action =
                    ConditionalAndBooleanFragmentDirections.actionConditionalAndBooleanFragmentToContainsFragment()
                findNavController().navigate(action)
            }
            buttonDefaultIfEmpty.setOnClickListener {
                val action =
                    ConditionalAndBooleanFragmentDirections.actionConditionalAndBooleanFragmentToDefaultIfEmptyFragment()
                findNavController().navigate(action)
            }
            buttonSequenceEqual.setOnClickListener {
                val action =
                    ConditionalAndBooleanFragmentDirections.actionConditionalAndBooleanFragmentToSequenceEqualFragment()
                findNavController().navigate(action)
            }
            buttonSkipUntil.setOnClickListener {
                val action =
                    ConditionalAndBooleanFragmentDirections.actionConditionalAndBooleanFragmentToSkipUntilFragment()
                findNavController().navigate(action)
            }
            buttonSkipWhile.setOnClickListener {
                val action =
                    ConditionalAndBooleanFragmentDirections.actionConditionalAndBooleanFragmentToSkipWhileFragment()
                findNavController().navigate(action)
            }
            buttonTakeUntil.setOnClickListener {
                val action =
                    ConditionalAndBooleanFragmentDirections.actionConditionalAndBooleanFragmentToTakeUntilFragment()
                findNavController().navigate(action)
            }
            buttonTakeWhile.setOnClickListener {
                val action =
                    ConditionalAndBooleanFragmentDirections.actionConditionalAndBooleanFragmentToTakeWhileFragment()
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
        fragmentConditionalAndBooleanBinding = null
        super.onDestroyView()
    }

}