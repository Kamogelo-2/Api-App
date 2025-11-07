package com.example.apiapp // Make sure this package name matches yours

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.apiapp.databinding.ActivitySettingsBinding
import com.example.apiapp.utils.PreferencesHelper

class SettingsActivity : AppCompatActivity() {

    private companion object {
        const val TAG = "SettingsActivity"
    }

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var prefsHelper: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: SettingsActivity started.")
        prefsHelper = PreferencesHelper(this)

        // Load saved preferences into the UI
        loadSettings()

        // Set up all click/change listeners
        setupClickListeners()
    }

    private fun loadSettings() {
        Log.d(TAG, "loadSettings: Loading user preferences.")

        // Load Dark Mode switch state
        val isDarkMode = prefsHelper.isDarkModeEnabled()
        binding.switchDarkMode.isChecked = isDarkMode

        // TODO: Load user profile data
        // val userName = ... get from SecureStorage ...
        // val userEmail = ... get from SecureStorage ...
        // binding.tvUserName.text = userName
        // binding.tvUserEmail.text = userEmail
    }

    private fun setupClickListeners() {
        Log.d(TAG, "setupClickListeners: Setting up...")

        // --- Preferences Listeners ---

        binding.switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            Log.d(TAG, "Dark Mode switch toggled: $isChecked")
            prefsHelper.setDarkModeEnabled(isChecked)

            // Apply the theme
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        binding.switchNotifications.setOnCheckedChangeListener { _, isChecked ->
            Log.d(TAG, "Notifications switch toggled: $isChecked")
            // TODO: Save this preference
            showToast("Notification setting changed: $isChecked")
        }

        binding.btnLanguage.setOnClickListener {
            Log.d(TAG, "Language button clicked.")
            // TODO: Show a language picker dialog
            showToast("Language selection coming soon!")
        }

        // --- Profile Listener ---

        binding.btnLogout.setOnClickListener {
            Log.d(TAG, "Logout button clicked.")
            showLogoutConfirmationDialog()
        }

        // --- Bottom Navigation Bar ---

        binding.btnNavHome.setOnClickListener {
            Log.d(TAG, "Nav 'Home' clicked.")
            navigateTo(DashboardActivity::class.java)
        }

        binding.btnNavAdd.setOnClickListener {
            Log.d(TAG, "Nav 'Add' clicked.")
            navigateTo(AddExpenseActivity::class.java)
        }

        binding.btnNavReports.setOnClickListener {
            Log.d(TAG, "Nav 'Reports' clicked.")
            navigateTo(ReportsActivity::class.java)
        }

        binding.btnNavSettings.setOnClickListener {
            Log.d(TAG, "Nav 'Settings' clicked (already here).")
        }
    }

    private fun showLogoutConfirmationDialog() {
        Log.d(TAG, "showLogoutConfirmationDialog: Showing dialog.")
        AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Are you sure you want to log out?")
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setPositiveButton("Logout") { _, _ ->
                Log.i(TAG, "User confirmed logout.")
                performLogout()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                Log.d(TAG, "User cancelled logout.")
                dialog.dismiss()
            }
            .show()
    }

    private fun performLogout() {
        // TODO: Clear all user data from SecureStorage
        // Example: secureStorage.clearUserData()

        Log.i(TAG, "performLogout: Clearing user data and navigating to LoginActivity.")

        // Navigate to LoginActivity and clear the entire app history
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    /** Helper function for bottom navigation */
    private fun navigateTo(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}