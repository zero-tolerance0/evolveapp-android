package org.evolveapp.marathoner.ui.main

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import org.evolveapp.marathoner.R
import org.evolveapp.marathoner.databinding.ActivityMainBinding
import org.michaelbel.bottomsheet.BottomSheet

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        resolveDestinationChangedListener()
        initBottomNavClickListeners()


    }

    private fun initBottomNavClickListeners() {
        binding.bottomNav.marathon.setOnClickListener {
            navController.navigate(R.id.marathonsFragment)
        }

        binding.bottomNav.search.setOnClickListener {
            navController.navigate(R.id.searchFragment)
        }

        binding.bottomNav.profile.setOnClickListener {
            navController.navigate(R.id.profileFragment)
        }
    }

    private fun resolveDestinationChangedListener() {

        navController.addOnDestinationChangedListener { _, destination, _ ->

            val activeColor = ContextCompat.getColor(this, R.color.colorPrimary)

            when (destination.id) {

                R.id.marathonsFragment -> {
                    binding.bottomNav.marathon.setColorFilter(activeColor)
                    binding.bottomNav.search.setColorFilter(Color.BLACK)
                    binding.bottomNav.profile.setStrokeColor(ColorStateList.valueOf(Color.TRANSPARENT))
                }

                R.id.searchFragment -> {
                    binding.bottomNav.marathon.setColorFilter(Color.BLACK)
                    binding.bottomNav.search.setColorFilter(activeColor)
                    binding.bottomNav.profile.setStrokeColor(ColorStateList.valueOf(Color.TRANSPARENT))
                }

                R.id.profileFragment -> {
                    binding.bottomNav.marathon.setColorFilter(Color.BLACK)
                    binding.bottomNav.search.setColorFilter(Color.BLACK)
                    binding.bottomNav.profile.setStrokeColor(ColorStateList.valueOf(activeColor))
                }

            }

        }

    }

}