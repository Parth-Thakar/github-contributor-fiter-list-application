package com.example.githubcoroutine_rsl.adapters

import android.annotation.SuppressLint
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubcoroutine_rsl.R

class GroupContributorsRecyclerViewAdapter(
    val dataList: ArrayList<Int?>,
    val groupInformationList: ArrayList<String>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =
            inflater.inflate(R.layout.items_of_group_contributors_recyclerview, parent, false)
        return GroupContributorsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GroupContributorsViewHolder).bind(
            dataList[position].toString(),
            groupInformationList[position]
        )
    }
    override fun getItemCount(): Int {
        return dataList.size
    }

    // viewholder class bind function will bind the list data to recyclerview item's textview
    class GroupContributorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val displayGroupAndContributionTextView: TextView =
            itemView.findViewById(R.id.displayGroupAndContributionTextView)
        val groupInformationTextView: TextView =
            itemView.findViewById(R.id.groupInformationTextView)

        @SuppressLint("SetTextI18n")
        fun bind(contributionNumberStringToSet: String, groupInformationStringToSet: String) {
            if (contributionNumberStringToSet != itemView.context.getString(R.string.null_check)) {
                displayGroupAndContributionTextView.text = contributionNumberStringToSet
            } else {
                displayGroupAndContributionTextView.text =
                    itemView.context.getString(R.string.zero_contribution)
            }
            groupInformationTextView.text = groupInformationStringToSet
        }

    }
}