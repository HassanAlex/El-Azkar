package com.codestation.elazkar.ui.fragments.elazkar

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.codestation.elazkar.adapters.ElzkerAdapter
import com.codestation.elazkar.databinding.FragmentMorningAzkarBinding
import com.codestation.elazkar.repo.Repository
import com.codestation.elazkar.ui.ElazkarViewModelFactory


class MorningAzkarFragment : Fragment() {

    lateinit var binding: FragmentMorningAzkarBinding
    private lateinit var morningViewModel: ElAzkarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMorningAzkarBinding.inflate(inflater, container, false)
        setUpViewModel()

        //viewModel = ViewModelProvider(this)[MorningAzkarViewModel::class.java]

        morningViewModel.azkarMorningList.observe(viewLifecycleOwner) {
            val adapter = ElzkerAdapter(it)
            binding.recyclerMorning.adapter = adapter
        }
        return binding.root
    }

    private fun setUpViewModel() {
        val morningRepository = Repository()
        val viewModelFactory = ElazkarViewModelFactory(requireActivity().application, morningRepository)

        morningViewModel = ViewModelProvider(this, viewModelFactory)[ElAzkarViewModel::class.java]
    }






}