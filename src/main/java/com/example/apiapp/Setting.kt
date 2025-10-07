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

class Setting : AppCompatActivity() {
    private var editTextValue1: String = ""
    private var editTextValue2: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_setting)
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/vaqx26w8_expires_30_days.png").into(findViewById(R.id.r6vmthigxxxx))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/3omgdcoe_expires_30_days.png").into(findViewById(R.id.rmdeqhphey3i))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/oqkp8l8r_expires_30_days.png").into(findViewById(R.id.r56ux5foy0fx))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/2o3058ek_expires_30_days.png").into(findViewById(R.id.r0i029zieuzhk))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/hqfagfqe_expires_30_days.png").into(findViewById(R.id.rrnf11tpst3b))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/821van6j_expires_30_days.png").into(findViewById(R.id.rppz2qxenm6n))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/f33qtj41_expires_30_days.png").into(findViewById(R.id.royby50w9rb))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/zhgo6zfg_expires_30_days.png").into(findViewById(R.id.rw3vlhvhc05i))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/mcmpy74i_expires_30_days.png").into(findViewById(R.id.rs2myzqrxvln))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/7c427ge0_expires_30_days.png").into(findViewById(R.id.ri18dj2ltmqo))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/ch4l0pcw_expires_30_days.png").into(findViewById(R.id.rrgb0z1ih6k))
            val editText1: EditText = findViewById(R.id.r29vy5ra0tlm)
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
            val editText2: EditText = findViewById(R.id.r4jvmf5n2e2t)
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
            val button1: View = findViewById(R.id.rb9lg685izw)
            button1.setOnClickListener {
                println("Pressed")
            }
            val button2: View = findViewById(R.id.r8bcgus7uosv)
            button2.setOnClickListener {
                println("Pressed")
            }
            val button3: View = findViewById(R.id.r1czc28c1mcp)
            button3.setOnClickListener {
                println("Pressed")
            }
        }}
