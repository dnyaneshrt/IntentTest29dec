package com.tech.intenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        var tv= findViewById<TextView>(R.id.tv)


      var name=  intent.getStringExtra("myname")

       tv.text="welcome here :$name"


    }
}