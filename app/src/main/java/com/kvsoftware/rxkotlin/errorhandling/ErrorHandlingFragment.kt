package com.kvsoftware.rxkotlin.errorhandling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kvsoftware.rxkotlin.databinding.FragmentErrorHandlingBinding

class ErrorHandlingFragment : Fragment() {

    private var fragmentErrorHandlingBinding: FragmentErrorHandlingBinding? = null

    private val viewModel: ErrorHandlingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentErrorHandlingBinding.inflate(inflater, container, false)
        fragmentErrorHandlingBinding = binding
        binding.apply {
            buttonCatch.setOnClickListener {
                val action =
                    ErrorHandlingFragmentDirections.actionErrorHandlingFragmentToCatchFragment()
                findNavController().navigate(action)
            }
            buttonRetry.setOnClickListener {
                val action =
                    ErrorHandlingFragmentDirections.actionErrorHandlingFragmentToRetryFragment()
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
        fragmentErrorHandlingBinding = null
        super.onDestroyView()
    }
}