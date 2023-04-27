package com.example.githubcoroutine_rsl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.githubcoroutine_rsl.api.ContributorApi
import com.example.githubcoroutine_rsl.api.RetrofitHelper
import com.example.githubcoroutine_rsl.fragments.GroupContributorsFragments
import com.example.githubcoroutine_rsl.fragments.LessThan1kContributionFragment
import com.example.githubcoroutine_rsl.fragments.LessThan5kFollowersFragments
import com.example.githubcoroutine_rsl.fragments.PrettifiedStringsFragment
import com.example.githubcoroutine_rsl.models.ContributorList
import com.example.githubcoroutine_rsl.repository.ContributorRepository
import com.example.githubcoroutine_rsl.viewmodels.MainViewModelFactory
import com.example.githubcoroutine_rsl.viewmodels.MainViewModels

class MainActivity : AppCompatActivity() {
    lateinit var mainviewmodel: MainViewModels

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contributorApi = RetrofitHelper.getInstance().create(ContributorApi::class.java)

        val repository = ContributorRepository(contributorApi)
        // creating the viewmodel object
        mainviewmodel = ViewModelProvider(
            this,
            MainViewModelFactory(repository)
        ).get(MainViewModels::class.java)


        var listToSend = ContributorList()
        // fetching the data from live data.
        mainviewmodel.contributors.observe(this) {
            listToSend = it
        }


        val openPrettifiedStringsFragmentButton: Button = findViewById(R.id.prettifiedStringButton)
        val lessThan5KButton: Button = findViewById(R.id.lessThan5KButton)
        val lessThan1KButton: Button = findViewById(R.id.lessThan1KButton)
        val groupContributorsButton: Button = findViewById(R.id.groupContributorsButton)

        // loading the different fragments on different button clicked
        groupContributorsButton.setOnClickListener {
            val groupContributorsFragments = GroupContributorsFragments()
            loadfragment(listToSend, groupContributorsFragments)
        }

        lessThan1KButton.setOnClickListener {
            val lessThan1kContributionFragment = LessThan1kContributionFragment()
            loadfragment(listToSend, lessThan1kContributionFragment)
        }

        openPrettifiedStringsFragmentButton.setOnClickListener {
            val prettifiedStringsFragment = PrettifiedStringsFragment()
            loadfragment(listToSend, prettifiedStringsFragment)
        }

        lessThan5KButton.setOnClickListener {
            val lessThan5kFollowersFragments = LessThan5kFollowersFragments()
            loadfragment(listToSend, lessThan5kFollowersFragments)
        }


    }
    // loading different fragment
    private fun loadfragment(
        listToSend: ContributorList,
        fragment: Fragment
    ) {
        // sending the fetched data from api through bundle to another fragments.
        val bundle = Bundle()
        bundle.putSerializable(getString(R.string.bundle_key), listToSend)
        fragment.arguments = bundle
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentSpace, fragment).commit()

    }
}