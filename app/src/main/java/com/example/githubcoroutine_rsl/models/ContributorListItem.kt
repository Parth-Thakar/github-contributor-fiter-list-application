package com.example.githubcoroutine_rsl.models

// data class of JSON given
data class ContributorListItem(
    val contributions: Int,
    val followers: Double,
    val gravatar: String,
    val language: String,
    val location: String,
    val login: String,
    val name: String,
    val organizations: List<String>
)