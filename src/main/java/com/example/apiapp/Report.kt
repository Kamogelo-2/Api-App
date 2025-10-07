package com.example.apiapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import com.bumptech.glide.Glide

class Report : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_report)
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/qtmvz624_expires_30_days.png").into(findViewById(R.id.ru3nxc7i5ize))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/c57hnhe5_expires_30_days.png").into(findViewById(R.id.ra0xoxb5v5am))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/zcpoc1xi_expires_30_days.png").into(findViewById(R.id.rv1x4v1emta))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/uzxyp489_expires_30_days.png").into(findViewById(R.id.rb4t6nm847th))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/cxx6we0s_expires_30_days.png").into(findViewById(R.id.r5gz5ympr22u))
        val button1: View = findViewById(R.id.r6cafogaxoqm)
        button1.setOnClickListener {
            println("Pressed")
        }
    }
}