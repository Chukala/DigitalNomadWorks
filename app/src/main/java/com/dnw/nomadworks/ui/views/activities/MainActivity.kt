package com.dnw.nomadworks.ui.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.dnw.nomadworks.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btmNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val navController = Navigation.findNavController(this,R.id.fragment_container)

        NavigationUI.setupWithNavController(btmNavigationView,navController)

    }


}