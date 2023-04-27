package com.example.githubcoroutine_rsl.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubcoroutine_rsl.R
import com.example.githubcoroutine_rsl.adapters.LessThan5kFollowersRecyclerViewAdapter
import com.example.githubcoroutine_rsl.adapters.PrettifiedStringsRecyclerViewAdapter
import com.example.githubcoroutine_rsl.models.ContributorList

class LessThan5kFollowersFragments : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =
            inflater.inflate(R.layout.fragment_less_than5k_followers_fragments, container, false)

        val args = this.arguments

        val contributorList = args?.get(getString(R.string.bundle_key)) as ContributorList

        val recyclerView: RecyclerView = view.findViewById(R.id.lessThan5KfollowersRecyclerView)

        // creating the Linear Layout Manager Object
        val layoutManager = LinearLayoutManager(activity)
        // Setting the Linear Layout manager to recyclerview
        recyclerView.layoutManager = layoutManager
        // storing data of those contributors who have more than 5k followers in just form 20 data from the JSON data
        val list = ContributorList()

        for (i in 0 until 20) {
            if (contributorList[i].followers > 5000) {
                list.add(contributorList[i])
            }
        }

        // setting up the adapter.
        recyclerView.adapter = LessThan5kFollowersRecyclerViewAdapter(list)

        return view
    }


}