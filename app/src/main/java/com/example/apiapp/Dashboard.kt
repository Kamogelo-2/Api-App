package com.example.apiapp // Make sure this package name matches yours

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apiapp.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private companion object {
        const val TAG = "DashboardActivity"
    }

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: DashboardActivity started.")

        // Set up click listeners
        setupClickListeners()

        // You would also load user data here
        loadDashboardData()
    }

    private fun setupClickListeners() {
        Log.d(TAG, "setupClickListeners: Setting up all dashboard click listeners.")

        // Main "Add Expense" button
        binding.btnAddExpense.setOnClickListener {
            Log.d(TAG, "Add Expense button clicked. Launching AddExpenseActivity.")
            startActivity(Intent(this, AddExpenseActivity::class.java))
        }

        // Other quick actions
        binding.btnCategories.setOnClickListener {
            Log.d(TAG, "Categories button clicked.")
            showToast("Categories feature coming soon!")
        }

        binding.btnReports.setOnClickListener {
            Log.d(TAG, "Reports button clicked.")
            showToast("Reports feature coming soon!")
        }

        binding.btnQuickSettings.setOnClickListener {
            Log.d(TAG, "Quick Settings button clicked.")
            showToast("Settings feature coming soon!")
        }

        // Header settings button
        binding.btnSettings.setOnClickListener {
            Log.d(TAG, "Header Settings button clicked.")
            showToast("Main Settings feature coming soon!")
        }

        // View all transactions
        binding.tvViewAllTransactions.setOnClickListener {
            Log.d(TAG, "View All Transactions clicked.")
            showToast("Transaction list feature coming soon!")
        }
    }

    private fun loadDashboardData() {
        Log.d(TAG, "loadDashboardData: Loading user data...")
        // TODO: Replace this with real data from your secure storage or database

        // Example of setting the welcome message
        // val userName = ... get from storage ...
        // binding.tvWelcomeUser.text = "Hello, $userName!"

        binding.tvTotalSpentAmount.text = "R 4500.00"
        binding.tvThisMonthAmount.text = "R 4500.00"
        Log.d(TAG, "loadDashboardData: Dummy data loaded.")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}