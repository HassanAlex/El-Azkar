package com.codestation.elazkar.ui.fragments.morning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.codestation.elazkar.adapters.ElzkerAdapter
import com.codestation.elazkar.databinding.FragmentMorningAzkarBinding


class MorningAzkarFragment : Fragment() {

    lateinit var binding: FragmentMorningAzkarBinding
    private lateinit var viewModel: MorningAzkarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMorningAzkarBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MorningAzkarViewModel::class.java]

        viewModel.azkarMorningList.observe(viewLifecycleOwner) {
            val adapter = ElzkerAdapter(it)
            binding.recyclerMorning.adapter = adapter
        }
        return binding.root
    }


}