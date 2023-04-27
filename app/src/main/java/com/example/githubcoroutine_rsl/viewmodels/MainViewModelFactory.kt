package com.example.githubcoroutine_rsl.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubcoroutine_rsl.repository.ContributorRepository

class MainViewModelFactory(private val repository: ContributorRepository) : ViewModelProvider.Factory {
    // MAINVIEWMODEL FACTORY THAT WAS RECOMMENDED FOR MULTIPLE INSTANCW OF THE MAINVIEWMODEL
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return MainViewModels(repository) as T
    }

}