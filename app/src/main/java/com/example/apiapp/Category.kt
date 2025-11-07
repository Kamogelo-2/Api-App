package com.example.apiapp // Make sure this package name matches yours

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apiapp.databinding.ActivityCategoriesBinding

class CategoriesActivity : AppCompatActivity() {

    private companion object {
        const val TAG = "CategoriesActivity"
    }

    private lateinit var binding: ActivityCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: CategoriesActivity started.")

        // Set up all click listeners
        setupClickListeners()
    }

    private fun setupClickListeners() {
        Log.d(TAG, "setupClickListeners: Setting up all static click listeners.")

        // Header "Add Category" button
        binding.btnAddCategory.setOnClickListener {
            Log.d(TAG, "Add Category button clicked. Launching AddNewCategoryActivity.")
            startActivity(Intent(this, AddNewCategoryActivity::class.java))
        }

        // --- Static Category Item Listeners ---
        // In a RecyclerView, you would not do this.
        binding.categoryFood.setOnClickListener { showCategoryToast("Food & Dining") }
        binding.categoryTransport.setOnClickListener { showCategoryToast("Transport") }
        binding.categoryShopping.setOnClickListener { showCategoryToast("Shopping") }
        binding.categoryEntertainment.setOnClickListener { showCategoryToast("Entertainment") }
        binding.categoryBills.setOnClickListener { showCategoryToast("Bills & Utilities") }
        binding.categoryHealthcare.setOnClickListener { showCategoryToast("Healthcare") }
        binding.categoryEducation.setOnClickListener { showCategoryToast("Education") }
        binding.categoryOther.setOnClickListener { showCategoryToast("Other") }

        // --- Bottom Navigation Bar ---
        binding.btnNavAdd.setOnClickListener {
            Log.d(TAG, "Nav 'Add' clicked. Launching AddExpenseActivity.")
            startActivity(Intent(this, AddExpenseActivity::class.java))
        }

        binding.btnNavReports.setOnClickListener {
            Log.d(TAG, "Nav 'Reports' clicked.")
            showToast("Reports feature coming soon!")
        }

        binding.btnNavSettings.setOnClickListener {
            Log.d(TAG, "Nav 'Settings' clicked.")
            showToast("Settings feature coming soon!")
        }
    }

    private fun showCategoryToast(categoryName: String) {
        Log.d(TAG, "Clicked on category: $categoryName")
        showToast("Clicked on $categoryName")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}