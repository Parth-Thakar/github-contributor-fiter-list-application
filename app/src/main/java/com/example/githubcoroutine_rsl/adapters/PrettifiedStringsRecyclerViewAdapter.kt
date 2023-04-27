package com.example.githubcoroutine_rsl.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.githubcoroutine_rsl.R
import com.example.githubcoroutine_rsl.models.ContributorList
import java.security.AccessController.getContext

class PrettifiedStringsRecyclerViewAdapter(val dataList: ContributorList) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =
            inflater.inflate(R.layout.items_of_prettified_strings_recyclerview, parent, false)
        return PrettifiedStringsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val currentName = dataList[position].name
        val currentContribution = dataList[position].contributions
        (holder as PrettifiedStringsViewHolder).bind(currentName + holder.itemView.context.getString(R.string.has_made_template_text) + currentContribution)


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    // viewholder class bind function will bind the list data to recyclerview item's textview
    class PrettifiedStringsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val displayNameAndContributionTextView: TextView =
            itemView.findViewById(R.id.displayNameAndContributionTextView)

        fun bind(stringToSet: String) {
            displayNameAndContributionTextView.text = stringToSet
        }

    }

}