package com.example.githubcoroutine_rsl.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubcoroutine_rsl.R
import com.example.githubcoroutine_rsl.models.ContributorList

class LessThan5kFollowersRecyclerViewAdapter(val dataList: ContributorList) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =
            inflater.inflate(R.layout.items_of_lessthan5k_followers_recyclerview, parent, false)
        return LessThan5kFollowersViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentName = dataList[position].name
        val currentFollowers = dataList[position].followers
        if (currentFollowers > 5000) {
            (holder as LessThan5kFollowersViewHolder).bind(
                currentName
            )
        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }

    // viewholder class bind function will bind the list data to recyclerview item's textview
    class LessThan5kFollowersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val displayNameAndContributionTextView: TextView =
            itemView.findViewById(R.id.displayNameTextView)

        fun bind(stringToSet: String) {
            displayNameAndContributionTextView.text = stringToSet
        }
    }
}