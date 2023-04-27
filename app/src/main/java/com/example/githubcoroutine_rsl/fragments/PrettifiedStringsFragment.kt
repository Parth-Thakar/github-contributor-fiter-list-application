package com.example.githubcoroutine_rsl.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubcoroutine_rsl.R
import com.example.githubcoroutine_rsl.adapters.PrettifiedStringsRecyclerViewAdapter
import com.example.githubcoroutine_rsl.api.ContributorApi
import com.example.githubcoroutine_rsl.api.RetrofitHelper
import com.example.githubcoroutine_rsl.models.ContributorList
import com.example.githubcoroutine_rsl.repository.ContributorRepository
import com.example.githubcoroutine_rsl.viewmodels.MainViewModelFactory
import com.example.githubcoroutine_rsl.viewmodels.MainViewModels

class PrettifiedStringsFragment : Fragment() {
    lateinit var mainviewmodel: MainViewModels
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_prettified_strings, container, false)
        // fetching the datalist form the arguments of this fragments
        val args = this.arguments

        val contributorList = args?.get(getString(R.string.bundle_key)) as ContributorList

        val recyclerView: RecyclerView = view.findViewById(R.id.prettifiedStringRecyclerView)

        // creating the Linear Layout Manager Object
        val layoutManager = LinearLayoutManager(activity)
        // Setting the Linear Layout manager to recyclerview
        recyclerView.layoutManager = layoutManager

        val from20ContributorList = ContributorList()

        // storing only 20 data list to from20ContributorList to send to Adapter of recyclerview
        for(i in 0 until 20)
        {
            from20ContributorList.add(contributorList[i])
        }

        recyclerView.adapter = PrettifiedStringsRecyclerViewAdapter(from20ContributorList)

        return view
    }

}