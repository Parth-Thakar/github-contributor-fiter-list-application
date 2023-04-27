package com.example.githubcoroutine_rsl.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.githubcoroutine_rsl.api.ContributorApi
import com.example.githubcoroutine_rsl.models.ContributorList

class ContributorRepository(private val contributorApi: ContributorApi) {


    private val contributorLiveData = MutableLiveData<ContributorList>()
    // creating the Live Data for the viewmodel
    val contributors: LiveData<ContributorList>
        get() = contributorLiveData

    suspend fun getContributor() {
        val result = contributorApi.getContributor()
        if (result?.body() != null) {
            contributorLiveData.postValue(result.body())
        }
    }

}