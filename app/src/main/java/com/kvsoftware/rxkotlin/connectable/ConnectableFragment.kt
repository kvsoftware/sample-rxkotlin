package com.kvsoftware.rxkotlin.connectable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kvsoftware.rxkotlin.databinding.FragmentConnectableBinding

class ConnectableFragment : Fragment() {

    private var fragmentConnectableBinding: FragmentConnectableBinding? = null

    private val viewModel: ConnectableViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding = FragmentConnectableBinding.inflate(inflater, container, false)
        fragmentConnectableBinding = binding
        binding.apply {
            buttonConnect.setOnClickListener {
                val action =
                        ConnectableFragmentDirections.actionConnectableFragmentToConnectFragment()
                findNavController().navigate(action)
            }
            buttonPublish.setOnClickListener {
                val action =
                        ConnectableFragmentDirections.actionConnectableFragmentToPublishFragment()
                findNavController().navigate(action)
            }
            buttonRefCount.setOnClickListener {
                val action =
                        ConnectableFragmentDirections.actionConnectableFragmentToRefCountFragment()
                findNavController().navigate(action)
            }
            buttonReplay.setOnClickListener {
                val action =
                        ConnectableFragmentDirections.actionConnectableFragmentToReplayFragment()
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
        fragmentConnectableBinding = null
        super.onDestroyView()
    }

}