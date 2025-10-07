package com.example.apiapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import com.bumptech.glide.Glide
class Expense : AppCompatActivity() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_expense)
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/jtltkhyy_expires_30_days.png").into(findViewById(R.id.rxl1lrgot3th))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/2en6gf9p_expires_30_days.png").into(findViewById(R.id.ri26kbxoguo))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/7ag1ho1a_expires_30_days.png").into(findViewById(R.id.rft20gv4er1r))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/mftvg0nt_expires_30_days.png").into(findViewById(R.id.rtrced57fsqe))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/3fjdtftm_expires_30_days.png").into(findViewById(R.id.rnssvmc5j6g))
            Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/XzC7nEBypE/iwiphyer_expires_30_days.png").into(findViewById(R.id.rps1i8bh7doe))
            val button1: View = findViewById(R.id.rjx0pmx6olr)
            button1.setOnClickListener {
                println("Pressed")
            }
            val button2: View = findViewById(R.id.rqy8rz044yk)
            button2.setOnClickListener {
                println("Pressed")
            }
        }
    }