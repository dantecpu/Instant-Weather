package com.mayokunadeniyi.instantweather.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mayokunadeniyi.instantweather.R
import com.mayokunadeniyi.instantweather.databinding.ActivityMainBinding
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.mainNavFragment)
        setupActionBarWithNavController(navController)
        binding.bottomNavBar.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.mainNavFragment).navigateUp()

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}
