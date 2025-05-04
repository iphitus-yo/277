package com.example.paranalog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.paranalog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // *** Added: Set the Toolbar as the support action bar ***
        setSupportActionBar(binding.toolbar)

        // Setup NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Define top-level destinations (no Up button on these screens)
        // Start with Register and Login as top-level, add ChecklistList as well
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.registerFragment, R.id.loginFragment, R.id.checklistListFragment)
        )

        // Setup ActionBar with NavController
        // This will now work because setSupportActionBar was called above
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    // Handle the Up button in the ActionBar
    override fun onSupportNavigateUp(): Boolean {
        // Let NavController handle Up navigation, considering AppBarConfiguration
        // Corrected: navigateUp() is called on NavController, passing appBarConfiguration
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}

