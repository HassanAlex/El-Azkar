package com.codestation.elazkar.ui.fragments.elazkar

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.codestation.elazkar.adapters.ElzkerAdapter
import com.codestation.elazkar.databinding.FragmentMorningAzkarBinding
import com.codestation.elazkar.repo.ElAzkarRepository
import com.codestation.elazkar.ui.ElazkarViewModelFactory


class MorningAzkarFragment : Fragment() {

    lateinit var binding: FragmentMorningAzkarBinding
    private val elAzkarRepository = ElAzkarRepository()

    private val morningViewModel: ElAzkarViewModel by viewModels {
        ElazkarViewModelFactory(requireContext(), elAzkarRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMorningAzkarBinding.inflate(inflater, container, false)


        morningViewModel.azkarMorningList.observe(viewLifecycleOwner) {
            val adapter = ElzkerAdapter(it)
            binding.recyclerMorning.adapter = adapter
        }
        return binding.root
    }

}