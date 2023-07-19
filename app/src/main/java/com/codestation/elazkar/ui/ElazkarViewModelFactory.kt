package com.codestation.elazkar.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codestation.elazkar.repo.Repository
import com.codestation.elazkar.ui.fragments.elazkar.ElAzkarViewModel

class ElazkarViewModelFactory(
    val app: Application,
    private val repository: Repository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ElAzkarViewModel(app, repository) as T
    }
}