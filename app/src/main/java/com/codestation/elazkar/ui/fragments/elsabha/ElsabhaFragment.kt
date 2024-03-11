package com.codestation.elazkar.ui.fragments.elsabha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.codestation.elazkar.databinding.FragmentElsabhaBinding


class ElsabhaFragment : Fragment() {

    private lateinit var binding: FragmentElsabhaBinding
    private lateinit var elsabhaViewModel: ElsabhaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentElsabhaBinding.inflate(inflater, container, false)

        elsabhaViewModel = ViewModelProvider(this)[ElsabhaViewModel::class.java]

        //1- add data
        binding.layIncrease.setOnClickListener {
            elsabhaViewModel.addNumbersInCounterList()
        }

        //2- observe on data change
        elsabhaViewModel.counterList.observe(viewLifecycleOwner) { number ->
            binding.tvCounter.text = number.toString()
        }

        //3- clear data
        binding.layIncrease.setOnLongClickListener {
            elsabhaViewModel.resetCounter()
            return@setOnLongClickListener true
        }

        return binding.root
    }


}