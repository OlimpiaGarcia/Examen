package com.example.kotlin.myapplication.framework.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlin.myapplication.R
import com.example.kotlin.myapplication.utils.Constants
import com.example.kotlin.myapplication.databinding.ActivityMainBinding
import com.example.kotlin.myapplication.framework.viewmodel.MainViewModel
import com.example.kotlin.myapplication.framework.views.fragments.MovieFragment
import com.example.kotlin.myapplication.framework.views.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    //Global variables
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var currentFragment: Fragment
    private var currentMenuOption: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        initializeListeners()
        exchangeCurrentFragment(MovieFragment(), Constants.MENU_MOVIE)

    }

    private fun initializeListeners(){
        binding.appBarMain.llPokedex.setOnClickListener {
            selectMenuOption(Constants.MENU_MOVIE)
        }

        binding.appBarMain.llSearch.setOnClickListener {
            selectMenuOption(Constants.MENU_SEARCH)
        }
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers() {

    }

    private fun exchangeCurrentFragment(newFragment: Fragment, newMenuOption:String){
        currentFragment = newFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main,currentFragment)
            .commit()

        currentMenuOption = newMenuOption
    }

    private fun selectMenuOption(menuOption:String){
        if(menuOption == currentMenuOption){
            return
        }

        when(menuOption){
            Constants.MENU_MOVIE -> exchangeCurrentFragment(MovieFragment(),Constants.MENU_MOVIE)
            Constants.MENU_SEARCH -> exchangeCurrentFragment(SearchFragment(),Constants.MENU_SEARCH)
        }
    }

}