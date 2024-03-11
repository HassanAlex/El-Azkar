package com.codestation.elazkar.ui.fragments.elazkar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.codestation.elazkar.adapters.ElzkerAdapter
import com.codestation.elazkar.databinding.FragmentEveningAzkarBinding
import com.codestation.elazkar.repo.ElAzkarRepository
import com.codestation.elazkar.ui.ElazkarViewModelFactory

class EveningAzkarFragment : Fragment() {

    private lateinit var binding: FragmentEveningAzkarBinding

    private val elAzkarRepository = ElAzkarRepository()

    private val eveningViewModel: ElAzkarViewModel by viewModels {
        ElazkarViewModelFactory(requireContext(), elAzkarRepository)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEveningAzkarBinding.inflate(inflater, container, false)

        eveningViewModel.azkarEveningList.observe(viewLifecycleOwner) {
            // set the adapter
            val adapter = ElzkerAdapter(it)
            //update the recycler view
            binding.recyclerEvening.adapter = adapter
        }
        return binding.root
    }
}