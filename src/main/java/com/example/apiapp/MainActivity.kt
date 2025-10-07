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
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        private var editTextValue1: String = ""
        private var editTextValue2: String = ""
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/eedf124u_expires_30_days.png").into(findViewById(R.id.r4xhxxlb6p0r))
        val editText1: EditText = findViewById(R.id.r23adnxgp5kz)
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
        val editText2: EditText = findViewById(R.id.riqunrp839la)
        editText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // before Text Changed
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                editTextValue2 = s.toString()  // on Text Changed
            }
            override fun afterTextChanged(s: Editable?) {
                // after Text Changed
            }
        })
        val button1: View = findViewById(R.id.rqx35gexsoon)
        button1.setOnClickListener {
            println("Pressed")
        }
        val button2: View = findViewById(R.id.r5y1rvn9iljj)
        button2.setOnClickListener {
            println("Pressed")
        }
        val button3: View = findViewById(R.id.rcj7galf0ki)
        button3.setOnClickListener {
            println("Pressed")
        }
        val button4: View = findViewById(R.id.roislrap5qjk)
        button4.setOnClickListener {
            println("Pressed")
        }
    }
}