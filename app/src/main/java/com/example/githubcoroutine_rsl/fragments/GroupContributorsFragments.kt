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
import com.example.githubcoroutine_rsl.adapters.GroupContributorsRecyclerViewAdapter
import com.example.githubcoroutine_rsl.models.ContributorList

class GroupContributorsFragments : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =
            inflater.inflate(R.layout.fragment_group_contributors_fragments, container, false)

        // fecthing the arguments
        val args = this.arguments
        //fetched the arguments with get function of particular key
        val contributorList = args?.get(getString(R.string.prettified_string_bundle_key)) as ContributorList
        // recycler view
        val recyclerView: RecyclerView = view.findViewById(R.id.groupOfContributorsRecyclerView)

        // creating the Linear Layout Manager Object
        val layoutManager = LinearLayoutManager(activity)
        // Setting the Linear Layout manager to recyclerview
        recyclerView.layoutManager = layoutManager

        val list = ContributorList()

        for (i in 0..19) {
            list.add(contributorList[i])
        }
        // making the maps using the groupBy function of the kotlin collections
        val groupedMap0to5k = list.groupBy { it.contributions in 0..5000 }
        val groupedMap5kto10k = list.groupBy { it.contributions in 5000..10000 }
        val groupedMap10kto15k = list.groupBy { it.contributions in 10000..15000 }
        val groupedMap15kto20k = list.groupBy { it.contributions in 15000..20000 }
        val groupedMap20kto25k = list.groupBy { it.contributions in 20000..25000 }
        val groupedMap25kto30k = list.groupBy { it.contributions in 25000..30000 }

        val numberOfContributionGroupWise = ArrayList<Int?>()

        // storing the grouped list in the list variables to apply the fold aggregate function to find the total number
        // of contribution made by each group
        val groupedList0to5k = groupedMap0to5k[true]
        val groupedList5kto10k = groupedMap5kto10k[true]
        val groupedList10kto15k = groupedMap10kto15k[true]
        val groupedList15kto20k = groupedMap15kto20k[true]
        val groupedList20kto25k = groupedMap20kto25k[true]
        val groupedList25kto30k = groupedMap25kto30k[true]

        // applying fold function on every list and storing it in another list of Int to sent to Recyclerview
        var contributionCountOfEachGroup =
            groupedList0to5k?.fold(0) { acc, contributorListItem -> acc + contributorListItem.contributions }
        numberOfContributionGroupWise.add(contributionCountOfEachGroup)

        contributionCountOfEachGroup =
            groupedList5kto10k?.fold(0) { acc, contributorListItem -> acc + contributorListItem.contributions }
        numberOfContributionGroupWise.add(contributionCountOfEachGroup)

        contributionCountOfEachGroup =
            groupedList10kto15k?.fold(0) { acc, contributorListItem -> acc + contributorListItem.contributions }
        numberOfContributionGroupWise.add(contributionCountOfEachGroup)


        contributionCountOfEachGroup =
            groupedList15kto20k?.fold(0) { acc, contributorListItem -> acc + contributorListItem.contributions }
        numberOfContributionGroupWise.add(contributionCountOfEachGroup)

        contributionCountOfEachGroup =
            groupedList20kto25k?.fold(0) { acc, contributorListItem -> acc + contributorListItem.contributions }
        numberOfContributionGroupWise.add(contributionCountOfEachGroup)

        contributionCountOfEachGroup =
            groupedList25kto30k?.fold(0) { acc, contributorListItem -> acc + contributorListItem.contributions }
        numberOfContributionGroupWise.add(contributionCountOfEachGroup)

        // making the group information list to display on recyclerview
        val groupInformation = ArrayList<String>()
        // adding the group information till 0k - 30k
        groupInformation.add(getString(R.string.group_1_text))
        groupInformation.add(getString(R.string.group_2_text))
        groupInformation.add(getString(R.string.group_3_text))
        groupInformation.add(getString(R.string.group_4_text))
        groupInformation.add(getString(R.string.group_5_text))
        groupInformation.add(getString(R.string.group_6_text))

        // setting the adapter to recyclerview
        recyclerView.adapter =
            GroupContributorsRecyclerViewAdapter(numberOfContributionGroupWise, groupInformation)

        return view
    }


}