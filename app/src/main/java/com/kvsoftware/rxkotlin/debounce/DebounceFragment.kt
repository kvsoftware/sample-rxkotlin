package com.kvsoftware.rxkotlin.debounce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kvsoftware.rxkotlin.LoggerHelper
import com.kvsoftware.rxkotlin.databinding.FragmentDebounceBinding

/**
 * The Debounce Operator
 * only emit an item from an Observable if a particular timespan has passed without it emitting another item
 */
class DebounceFragment : Fragment() {

    private var fragmentDebounceBinding: FragmentDebounceBinding? = null

    private val viewModel: DebounceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDebounceBinding.inflate(inflater, container, false)
        fragmentDebounceBinding = binding
        binding.edittext.listener = object : CustomEditText.Listener {
            override fun onTextChanged(text: String) {
                viewModel.search(text)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
        viewModel.data.observe(viewLifecycleOwner, {
            fragmentDebounceBinding?.recyclerview?.adapter = ColorAdapter(it)
        })
    }

    override fun onDestroyView() {
        fragmentDebounceBinding = null
        super.onDestroyView()
    }
}