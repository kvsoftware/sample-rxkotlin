package com.kvsoftware.rxkotlin.combining

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kvsoftware.rxkotlin.databinding.FragmentCombiningBinding

class CombiningFragment : Fragment() {

    private var fragmentCombiningBinding: FragmentCombiningBinding? = null

    private val viewModel: CombiningViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCombiningBinding.inflate(inflater, container, false)
        fragmentCombiningBinding = binding
        binding.apply {
            buttonCombineLatest.setOnClickListener {
                val action =
                    CombiningFragmentDirections.actionFilteringFragmentToCombineLatestFragment()
                findNavController().navigate(action)
            }
            buttonJoin.setOnClickListener {
                val action =
                    CombiningFragmentDirections.actionFilteringFragmentToJoinFragment()
                findNavController().navigate(action)
            }
            buttonMerge.setOnClickListener {
                val action =
                    CombiningFragmentDirections.actionFilteringFragmentToMergeFragment()
                findNavController().navigate(action)
            }
            buttonStartWith.setOnClickListener {
                val action =
                    CombiningFragmentDirections.actionFilteringFragmentToStartWithFragment()
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
        fragmentCombiningBinding = null
        super.onDestroyView()
    }

}