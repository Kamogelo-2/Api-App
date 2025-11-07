package com.example.apiapp // Make sure this package name matches yours

import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apiapp.databinding.ActivityAddExpenseBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddExpenseActivity : AppCompatActivity() {

    private companion object {
        const val TAG = "AddExpenseActivity"
    }

    private lateinit var binding: ActivityAddExpenseBinding
    private var selectedCategory: String? = null
    private var selectedCategoryView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: AddExpenseActivity started.")
        setupClickListeners()
    }

    private fun setupClickListeners() {
        Log.d(TAG, "setupClickListeners: Setting up...")

        // Save and Cancel buttons
        binding.btnSaveExpense.setOnClickListener {
            Log.d(TAG, "Save Expense button clicked.")
            handleSaveExpense()
        }
        binding.btnCancel.setOnClickListener {
            Log.d(TAG, "Cancel button clicked. Finishing activity.")
            finish() // Close this activity
        }

        // Date picker
        binding.etDate.setOnClickListener {
            Log.d(TAG, "Date EditText clicked. Showing DatePickerDialog.")
            showDatePicker()
        }

        // Category selection
        val categoryClickListener = View.OnClickListener { view ->
            val categoryName = when (view.id) {
                R.id.categoryFood -> "Food"
                R.id.categoryTransport -> "Transport"
                R.id.categoryShopping -> "Shopping"
                R.id.categoryEntertainment -> "Entertainment"
                R.id.categoryBills -> "Bills"
                R.id.categoryHealthcare -> "Healthcare"
                else -> null
            }
            categoryName?.let {
                selectCategory(view, it)
            }
        }

        binding.categoryFood.setOnClickListener(categoryClickListener)
        binding.categoryTransport.setOnClickListener(categoryClickListener)
        binding.categoryShopping.setOnClickListener(categoryClickListener)
        binding.categoryEntertainment.setOnClickListener(categoryClickListener)
        binding.categoryBills.setOnClickListener(categoryClickListener)
        binding.categoryHealthcare.setOnClickListener(categoryClickListener)
    }

    private fun selectCategory(view: View, categoryName: String) {
        // Reset previous selection
        selectedCategoryView?.setBackgroundResource(R.drawable.bg_edittext_normal)

        // Highlight new selection
        view.setBackgroundColor(Color.parseColor("#E8F0FE")) // Using your "focused" color

        selectedCategoryView = view
        selectedCategory = categoryName

        Log.d(TAG, "Category selected: $selectedCategory")
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val format = "yyyy-MM-dd"
            val sdf = SimpleDateFormat(format, Locale.US)
            val dateString = sdf.format(calendar.time)

            binding.etDate.setText(dateString)
            Log.d(TAG, "Date selected: $dateString")
        }

        DatePickerDialog(
            this,
            datePicker,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun handleSaveExpense() {
        val amount = binding.etAmount.text.toString().toDoubleOrNull()
        val description = binding.etDescription.text.toString().trim()
        val date = binding.etDate.text.toString()

        // --- Validation ---
        if (amount == null || amount <= 0) {
            Log.w(TAG, "Save failed: Invalid amount.")
            Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
            return
        }
        if (selectedCategory == null) {
            Log.w(TAG, "Save failed: No category selected.")
            Toast.makeText(this, "Please select a category", Toast.LENGTH_SHORT).show()
            return
        }
        if (date.isEmpty()) {
            Log.w(TAG, "Save failed: No date selected.")
            Toast.makeText(this, "Please select a date", Toast.LENGTH_SHORT).show()
            return
        }
        if (description.isEmpty()) {
            Log.w(TAG, "Save failed: No description provided.")
            Toast.makeText(this, "Please enter a description", Toast.LENGTH_SHORT).show()
            return
        }

        // --- All data is valid ---
        Log.i(TAG, "Expense Saved Successfully!")
        Log.i(TAG, "Amount: $amount")
        Log.i(TAG, "Category: $selectedCategory")
        Log.i(TAG, "Description: $description")
        Log.i(TAG, "Date: $date")

        // TODO: Save this data to your database (Room, Firebase, etc.)

        Toast.makeText(this, "Expense Saved!", Toast.LENGTH_SHORT).show()
        finish() // Go back to the Dashboard
    }
}