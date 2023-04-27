package com.example.githubcoroutine_rsl.api

import com.example.githubcoroutine_rsl.models.ContributorList
import retrofit2.Response
import retrofit2.http.GET

interface ContributorApi {

    // Get request with Api end point and suspend function as asked to use the coroutines
    @GET("github-users-stats.json")
    suspend fun getContributor() : Response<ContributorList>
}