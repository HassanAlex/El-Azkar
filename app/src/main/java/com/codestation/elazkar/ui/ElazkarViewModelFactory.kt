package com.codestation.elazkar.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codestation.elazkar.repo.ElAzkarRepository
import com.codestation.elazkar.ui.fragments.elazkar.ElAzkarViewModel

class ElazkarViewModelFactory(
    private val context: Context,
    private val elAzkarRepository: ElAzkarRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ElAzkarViewModel(context ,elAzkarRepository) as T
    }
}