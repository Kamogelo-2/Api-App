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

class SignUp : AppCompatActivity() {
    private var editTextValue1: String = ""
    private var editTextValue2: String = ""
    private var editTextValue3: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/091iamow_expires_30_days.png").into(findViewById(R.id.rjoju2oxc1wg))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/vqod47z4_expires_30_days.png").into(findViewById(R.id.rrfs1ttoz7nc))
        val editText1: EditText = findViewById(R.id.rexjdtm7wfn)
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
        val editText2: EditText = findViewById(R.id.r3epmfq5p4ff)
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
        val editText3: EditText = findViewById(R.id.rkg8jmw7x9c)
        editText3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // before Text Changed
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                editTextValue3 = s.toString()  // on Text Changed
            }
            override fun afterTextChanged(s: Editable?) {
                // after Text Changed
            }
        })
        val button1: View = findViewById(R.id.rj8rpep90z1f)
        button1.setOnClickListener {
            println("Pressed")
        }
        val button2: View = findViewById(R.id.rgq8ctldlx98)
        button2.setOnClickListener {
            println("Pressed")
        }
        val button3: View = findViewById(R.id.rj24jlwe744a)
        button3.setOnClickListener {
            println("Pressed")
        }
    }
}