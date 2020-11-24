package com.example.workwithfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.SparseArray
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.workwithfragments.extensions.deleteFromStack
import com.example.workwithfragments.extensions.setupWithNavController
import com.example.workwithfragments.fragments.DeepDark
import com.example.workwithfragments.fragments.LetsCelebrate
import com.example.workwithfragments.fragments.OhShit
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*
import kotlin.properties.Delegates

private var currentNavController: LiveData<NavController>? = null

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var order : ArrayList<Int>
    private var currentList by Delegates.notNull<Int>()
    private var graphIdToTagMap = SparseArray<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        order = savedInstanceState?.getIntegerArrayList("Values") ?:
                ArrayList<Int>().also { it.add(R.id.van_darkholme)}
        currentList = savedInstanceState?.getInt("Number") ?: 0
        setupBottomNavigation()
        if (savedInstanceState != null) {
            bottomNavigationView.selectedItemId = savedInstanceState.getInt("Key")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
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
                intent = intent,
                graphIdToTagMap = graphIdToTagMap,
                order = order,
                function = {newPage -> currentList = newPage}
        )
        // how and to what Fragment we will go
        currentNavController = controller
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Key", bottomNavigationView.selectedItemId)
        outState.putIntegerArrayList("Views", order)
        outState.putInt("Number", currentList)
    }

    override fun onBackPressed() {
        if (getCount(currentList) != 0 || order.size == 1) {
            super.onBackPressed()
        } else {
            currentList = bottomNavigationView.deleteFromStack(order, graphIdToTagMap)
        }
    }

    private fun getCount(list: Int): Int {
        return when (list) {
            0 -> DeepDark.number
            1 -> OhShit.number
            else -> LetsCelebrate.number
        }
    }
}