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

class Dashboard : AppCompatActivity() {
    private var editTextValue1: String = ""
    private var editTextValue2: String = ""
    private var editTextValue3: String = ""
    private var editTextValue4: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/2hxy2i7r_expires_30_days.png").into(findViewById(R.id.relyec7yo5cu))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/rj60t7fl_expires_30_days.png").into(findViewById(R.id.rc5b2lzf056))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/geemk6r4_expires_30_days.png").into(findViewById(R.id.ri94ethm026))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/vtzs4tph_expires_30_days.png").into(findViewById(R.id.rhfdco4kkzsl))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/eq6etz2p_expires_30_days.png").into(findViewById(R.id.rksgbg7oknso))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/2cqqfd1m_expires_30_days.png").into(findViewById(R.id.rgnntjk9pnw5))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/ugqik3ku_expires_30_days.png").into(findViewById(R.id.rdoztaccrzb4))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/5x8tmwdk_expires_30_days.png").into(findViewById(R.id.rdbam0wcc0bo))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/ygnny1vz_expires_30_days.png").into(findViewById(R.id.rrbap5j7u6hq))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/9c9ewyhd_expires_30_days.png").into(findViewById(R.id.rrb6yz254d4))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/goo0yi24_expires_30_days.png").into(findViewById(R.id.r9zcn4niz02))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/33yy2243_expires_30_days.png").into(findViewById(R.id.rmvea5qdb2rr))
        val editText1: EditText = findViewById(R.id.rzt1014aw69c)
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
        val editText2: EditText = findViewById(R.id.roihnsf6mpl)
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
        val editText3: EditText = findViewById(R.id.ra3yemesa12)
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
        val editText4: EditText = findViewById(R.id.r0dfat2cf1wn)
        editText4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // before Text Changed
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                editTextValue4 = s.toString()  // on Text Changed
            }
            override fun afterTextChanged(s: Editable?) {
                // after Text Changed
            }
        })
        val button1: View = findViewById(R.id.r8jfr3zr6qdm)
        button1.setOnClickListener {
            println("Pressed")
        }
        val button2: View = findViewById(R.id.r9ww0yjcszc)
        button2.setOnClickListener {
            println("Pressed")
        }
    }
}