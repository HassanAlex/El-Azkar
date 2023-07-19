package com.codestation.elazkar.ui.fragments.elazkar

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.codestation.elazkar.adapters.ElzkerAdapter
import com.codestation.elazkar.databinding.FragmentEveningAzkarBinding
import com.codestation.elazkar.repo.Repository
import com.codestation.elazkar.ui.ElazkarViewModelFactory

class EveningAzkarFragment : Fragment() {

    private lateinit var binding: FragmentEveningAzkarBinding
    private lateinit var eveningViewModel: ElAzkarViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEveningAzkarBinding.inflate(inflater, container, false)
        setUpViewModel()
        //eveningViewModel = ViewModelProvider(this)[ElAzkarViewModel::class.java]

        eveningViewModel.azkarEveningList.observe(viewLifecycleOwner) {
            // set the adapter
            val adapter = ElzkerAdapter(it)
            //update the recycler view
            binding.recyclerEvening.adapter = adapter
        }
        return binding.root
    }

    private fun setUpViewModel() {
        val morningRepository = Repository()
        val viewModelFactory = ElazkarViewModelFactory(requireActivity().application, morningRepository)

        eveningViewModel = ViewModelProvider(this, viewModelFactory)[ElAzkarViewModel::class.java]
    }





}