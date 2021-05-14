package com.kvsoftware.rxkotlin.connectable.connect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kvsoftware.rxkotlin.databinding.FragmentConnectBinding

class ConnectFragment : Fragment() {

    private var fragmentConnectBinding: FragmentConnectBinding? = null

    private val viewModel: ConnectViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentConnectBinding.inflate(inflater, container, false)
        fragmentConnectBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onDestroyView() {
        fragmentConnectBinding = null
        super.onDestroyView()
    }
}