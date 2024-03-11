package com.codestation.elazkar.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codestation.elazkar.ui.fragments.elazkar.EveningAzkarFragment
import com.codestation.elazkar.ui.fragments.elazkar.MorningAzkarFragment
import com.codestation.elazkar.ui.fragments.elradio.ElRadioFragment
import com.codestation.elazkar.ui.fragments.elsabha.ElsabhaFragment


class AdapterViewPager(
    fragmentManger: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManger, lifecycle) {


    override fun getItemCount(): Int = 4


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {MorningAzkarFragment()}
            1 -> {EveningAzkarFragment()}
            2 -> {ElsabhaFragment()}
            3 -> {ElRadioFragment()}
            else -> {MorningAzkarFragment()}
        }

    }

}