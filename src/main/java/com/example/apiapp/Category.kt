package com.example.apiapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class Category : AppCompatActivity() {
    private var editTextValue1: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_category)
        val editText1: EditText = findViewById(R.id.rxxwtiuegsac)
        editText1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // before Text Changed
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                editTextValue1 = s.toString()  // on Text Changed
            }
            override fun afterTextChanged(s: Editable?) {
                // after Text Changed
            }
        })
    }
}