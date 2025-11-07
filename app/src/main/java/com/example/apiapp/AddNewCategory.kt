package com.example.apiapp // Make sure this package name matches yours

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apiapp.databinding.ActivityAddNewCategoryBinding

class AddNewCategoryActivity : AppCompatActivity() {

    private companion object {
        const val TAG = "AddNewCategoryActivity"
    }

    private lateinit var binding: ActivityAddNewCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: AddNewCategoryActivity started.")

        // Set up all click listeners
        setupClickListeners()
    }

    private fun setupClickListeners() {
        Log.d(TAG, "setupClickListeners: Setting up listeners...")

        // Main "Add Category" button
        binding.btnAddCategory.setOnClickListener {
            Log.d(TAG, "Add Category button clicked.")
            handleSaveCategory()
        }

        // --- Bottom Navigation Bar Listeners ---
        binding.btnNavAdd.setOnClickListener {
            Log.d(TAG, "Nav 'Add' clicked. Launching AddExpenseActivity.")
            // Since we are already in an "add" screen, you might want to
            // just go to the AddExpenseActivity.
            val intent = Intent(this, AddExpenseActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // Clears this activity from the stack
            startActivity(intent)
        }

        binding.btnNavReports.setOnClickListener {
            Log.d(TAG, "Nav 'Reports' clicked.")
            showToast("Reports feature coming soon!")
            // TODO: Navigate to ReportsActivity
        }

        binding.btnNavSettings.setOnClickListener {
            Log.d(TAG, "Nav 'Settings' clicked.")
            showToast("Settings feature coming soon!")
            // TODO: Navigate to SettingsActivity
        }
    }

    private fun handleSaveCategory() {
        // Now reading from the functional EditText fields
        val name = binding.etCategoryName.text.toString().trim()
        val icon = binding.etCategoryIcon.text.toString().trim()
        val minGoal = binding.etMinGoal.text.toString().toDoubleOrNull()
        val maxGoal = binding.etMaxGoal.text.toString().toDoubleOrNull()

        // --- Validation ---
        if (name.isEmpty()) {
            Log.w(TAG, "Save failed: Category name is empty.")
            Toast.makeText(this, "Please enter a category name", Toast.LENGTH_SHORT).show()
            return
        }

        if (icon.isEmpty()) {
            Log.w(TAG, "Save failed: Category icon is empty.")
            Toast.makeText(this, "Please enter an icon (emoji)", Toast.LENGTH_SHORT).show()
            return
        }

        // --- Data is valid ---
        Log.i(TAG, "Category Save Successful!")
        Log.i(TAG, "Name: $name")
        Log.i(TAG, "Icon: $icon")
        Log.i(TAG, "Min Goal: $minGoal")
        Log.i(TAG, "Max Goal: $maxGoal")

        // TODO: Save this new category to your database (Room, Firebase, etc.)
        // After saving, you would finish the activity

        Toast.makeText(this, "Category '$name' added!", Toast.LENGTH_SHORT).show()
        finish() // Close this activity and go back to CategoriesActivity
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}