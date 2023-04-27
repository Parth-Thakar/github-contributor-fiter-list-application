package com.example.githubcoroutine_rsl.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubcoroutine_rsl.models.ContributorList
import com.example.githubcoroutine_rsl.repository.ContributorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModels(private val repository: ContributorRepository) : ViewModel() {


    init {
        // coroutine scope of viewModelScope.launch using dispatcher.IO to get the contributor list from the API
        viewModelScope.launch(Dispatchers.IO){
            repository.getContributor()
        }

    }
    // live data using getters of repository
    val contributors : LiveData<ContributorList>
    get() = repository.contributors


}