package com.example.apiapp // Make sure this package name matches yours

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apiapp.databinding.ActivityReportsBinding
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate

class ReportsActivity : AppCompatActivity() {

    private companion object {
        const val TAG = "ReportsActivity"
    }

    private lateinit var binding: ActivityReportsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: ReportsActivity started.")

        setupClickListeners()
        setupCharts()
        loadSummaryData()
    }

    private fun setupClickListeners() {
        Log.d(TAG, "setupClickListeners: Setting up...")

        // Month "Spinner"
        binding.btnMonthSpinner.setOnClickListener {
            Log.d(TAG, "Month spinner clicked.")
            // TODO: Show a real month picker dialog
            showToast("Month filter coming soon!")
        }

        // --- Bottom Navigation Bar ---
        binding.btnNavHome.setOnClickListener {
            Log.d(TAG, "Nav 'Home' clicked. Finishing activity.")
            // Assuming Dashboard is the "home"
            val intent = Intent(this, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }

        binding.btnNavAdd.setOnClickListener {
            Log.d(TAG, "Nav 'Add' clicked. Launching AddExpenseActivity.")
            val intent = Intent(this, AddExpenseActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }

        // Reports button is the current screen, no action needed
        binding.btnNavReports.setOnClickListener {
            Log.d(TAG, "Nav 'Reports' clicked (already here).")
        }

        binding.btnNavSettings.setOnClickListener {
            Log.d(TAG, "Nav 'Settings' clicked.")
            showToast("Settings feature coming soon!")
            // TODO: Navigate to SettingsActivity
        }
    }

    private fun setupCharts() {
        Log.d(TAG, "setupCharts: Initializing charts with dummy data.")
        loadSpendingByCategoryChart()
        loadBudgetPerformanceChart()
    }

    private fun loadSpendingByCategoryChart() {
        Log.d(TAG, "loadSpendingByCategoryChart: Setting up Pie Chart.")
        // 1. Create data entries
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(1500f, "Food"))
        entries.add(PieEntry(1000f, "Transport"))
        entries.add(PieEntry(2000f, "Shopping"))
        entries.add(PieEntry(500f, "Bills"))

        // 2. Create a data set
        val dataSet = PieDataSet(entries, "Spending by Category")
        dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()
        dataSet.valueTextColor = Color.BLACK
        dataSet.valueTextSize = 12f

        // 3. Create PieData object
        val pieData = PieData(dataSet)

        // 4. Configure and set data to chart
        binding.pieChartSpending.apply {
            data = pieData
            description.isEnabled = false
            isDrawHoleEnabled = true
            setHoleColor(Color.WHITE)
            setEntryLabelColor(Color.BLACK)
            legend.isEnabled = false // Hide the legend for a cleaner look
            animateY(1000) // Animate
            invalidate() // Refresh chart
        }
        Log.d(TAG, "loadSpendingByCategoryChart: Pie Chart loaded.")
    }

    private fun loadBudgetPerformanceChart() {
        Log.d(TAG, "loadBudgetPerformanceChart: Setting up Bar Chart.")
        // 1. Create data entries
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(1f, 1500f)) // "Food"
        entries.add(BarEntry(2f, 1000f)) // "Transport"
        entries.add(BarEntry(3f, 2000f)) // "Shopping"

        // 2. Create a data set
        val dataSet = BarDataSet(entries, "Budget Performance")
        dataSet.colors = ColorTemplate.VORDIPLOM_COLORS.toList()
        dataSet.valueTextColor = Color.BLACK
        dataSet.valueTextSize = 10f

        // 3. Create BarData object
        val barData = BarData(dataSet)

        // 4. Configure and set data to chart
        binding.barChartBudget.apply {
            data = barData
            description.isEnabled = false
            legend.isEnabled = false
            // Style axes
            xAxis.isEnabled = false // We'd use labels here in a real app
            axisLeft.axisMinimum = 0f // Start Y-axis at 0
            axisRight.isEnabled = false

            animateY(1000)
            invalidate()
        }
        Log.d(TAG, "loadBudgetPerformanceChart: Bar Chart loaded.")
    }

    private fun loadSummaryData() {
        Log.d(TAG, "loadSummaryData: Loading dummy summary data.")
        // TODO: Load real data
        binding.tvSummaryTotalSpent.text = "R 4500.00"
        binding.tvSummaryTransactionCount.text = "3 Transactions"
        binding.tvSummaryAvgSpent.text = "R 1500.00"
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}