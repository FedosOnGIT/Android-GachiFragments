package com.example.workwithfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.workwithfragments.extensions.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

private var currentNavController : LiveData<NavController>? = null

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
        if (savedInstanceState != null) {
            bottomNavigationView.selectedItemId = savedInstanceState.getInt("Key")
        }
    }

    override fun onSupportNavigateUp() : Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    private fun setupBottomNavigation() {
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        val navigationGraph = listOf(
            R.navigation.deep_dark_fantasies,
            R.navigation.oh_shit_i_sorry,
            R.navigation.without_further_interruption
        )
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navigationGraph,
            fragmentManager = supportFragmentManager,
            containerId = R.id.gachi_fragment,
            intent = intent
        )
        // how and to what Fragment we will go
        currentNavController = controller
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Key", bottomNavigationView.selectedItemId)
    }
}