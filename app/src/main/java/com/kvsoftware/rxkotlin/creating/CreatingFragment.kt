package com.kvsoftware.rxkotlin.creating

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kvsoftware.rxkotlin.databinding.FragmentCreatingBinding

class CreatingFragment : Fragment() {

    private var fragmentCreatingBinding: FragmentCreatingBinding? = null

    private val viewModel: CreatingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCreatingBinding.inflate(inflater, container, false)
        fragmentCreatingBinding = binding
        binding.apply {
            buttonCreate.setOnClickListener {
                val action = CreatingFragmentDirections.actionCreatingFragmentToCreateFragment()
                findNavController().navigate(action)
            }
            buttonDefer.setOnClickListener {
                val action = CreatingFragmentDirections.actionCreatingFragmentToDeferFragment()
                findNavController().navigate(action)
            }
            buttonEmpty.setOnClickListener {
                val action = CreatingFragmentDirections.actionCreatingFragmentToEmptyFragment()
                findNavController().navigate(action)
            }
            buttonNever.setOnClickListener {
                val action = CreatingFragmentDirections.actionCreatingFragmentToNeverFragment()
                findNavController().navigate(action)
            }
            buttonError.setOnClickListener {
                val action = CreatingFragmentDirections.actionCreatingFragmentToErrorFragment()
                findNavController().navigate(action)
            }
            buttonFrom.setOnClickListener {
                val action = CreatingFragmentDirections.actionCreatingFragmentToFromFragment()
                findNavController().navigate(action)
            }
            buttonInterval.setOnClickListener {
                val action = CreatingFragmentDirections.actionCreatingFragmentToIntervalFragment()
                findNavController().navigate(action)
            }
            buttonJust.setOnClickListener {
                val action = CreatingFragmentDirections.actionCreatingFragmentToJustFragment()
                findNavController().navigate(action)
            }
            buttonRange.setOnClickListener {
                val action = CreatingFragmentDirections.actionCreatingFragmentToRangeFragment()
                findNavController().navigate(action)
            }
            buttonRepeat.setOnClickListener {
                val action = CreatingFragmentDirections.actionCreatingFragmentToRepeatFragment()
                findNavController().navigate(action)
            }
            buttonTimer.setOnClickListener {
                val action = CreatingFragmentDirections.actionCreatingFragmentToTimerFragment()
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
        fragmentCreatingBinding = null
        super.onDestroyView()
    }
}