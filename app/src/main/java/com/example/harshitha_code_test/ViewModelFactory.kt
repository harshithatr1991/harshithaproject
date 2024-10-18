package com.example.harshitha_code_test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val repository: GitHubRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReposViewModel::class.java)) {
            return ReposViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
