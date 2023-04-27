package com.example.githubcoroutine_rsl.models

import java.io.Serializable

// just an serializable list than can be sent over to fragment using bundle
class ContributorList : ArrayList<ContributorListItem>(20) , Serializable