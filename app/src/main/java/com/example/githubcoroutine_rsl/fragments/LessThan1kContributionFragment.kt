package com.example.githubcoroutine_rsl.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubcoroutine_rsl.R
import com.example.githubcoroutine_rsl.adapters.PrettifiedStringsRecyclerViewAdapter
import com.example.githubcoroutine_rsl.models.ContributorList

class LessThan1kContributionFragment : Fragment() {


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_less_than1k_contribution, container, false)
        // fetching the arguments of this fragment.
        val args = this.arguments

        val contributorList = args?.get(getString(R.string.bundle_key)) as ContributorList

        val yesOrNoTextView : TextView = view.findViewById(R.id.yesOrNoTextView)
        // making a list to store only 20 data form the JSON data which have less than 1k contribution
        val list = ContributorList()

        for(i in 0 until 20)
        {
            if(contributorList[i].contributions<1000) {
                list.add(contributorList[i])
            }
        }
        // if list is empty display yes and not then set text of TextView to N0
        if(list.size != 0)
        {
            yesOrNoTextView.text = getString(R.string.yes)
        }
        else
        {
            yesOrNoTextView.text = getString(R.string.no)
        }

        return view
    }



}