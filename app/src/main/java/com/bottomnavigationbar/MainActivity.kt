package com.bottomnavigationbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bottomnavigationbar.databinding.ActivityMainBinding
import com.google.android.material.elevation.SurfaceColors

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor =
            SurfaceColors.SURFACE_2.getColor(this)  // Set color of system statusBar same as ActionBar

        val badge = binding.bottomNavigation.getOrCreateBadge(R.id.page_home)
        badge.isVisible = true
        badge.number = 99

        //usage 1 basic
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.page_home,
                R.id.page_favorite,
                R.id.page_settings
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigation.setupWithNavController(navController)

        //usage 2 advanced
        /*binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_home -> {
                    Toast.makeText(this, "Clicked Home", Toast.LENGTH_SHORT).show()
                    binding.bottomNavigation.removeBadge(item.itemId)
                    true
                }
                R.id.page_favorite -> {
                    Toast.makeText(this, "Clicked Favorite", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.page_settings -> {
                    Toast.makeText(this, "Clicked Settings", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }*/
    }
}