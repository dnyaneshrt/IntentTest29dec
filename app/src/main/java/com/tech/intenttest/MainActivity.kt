package com.tech.intenttest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var et_number: EditText? = null
    var et_name: EditText? = null

    var btn_dail: Button? = null
    var btn_welcome: Button? = null
    var btn_youtube: Button? = null
    var btn_udemy: Button? = null
    var btn_instagram: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        btn_dail?.setOnClickListener(this)
        btn_welcome?.setOnClickListener(this)

        btn_udemy?.setOnClickListener(this)
        btn_youtube?.setOnClickListener(this)
        btn_instagram?.setOnClickListener(this)
    }

    private fun init() {
        et_name = findViewById(R.id.et_name)
        et_number = findViewById(R.id.et_mobile_number)

        btn_dail = findViewById(R.id.btn_dial)
        btn_youtube = findViewById(R.id.btn_youtube);
        btn_udemy = findViewById(R.id.btn_udemy)
        btn_welcome = findViewById(R.id.btn_welcome)
        btn_instagram = findViewById(R.id.btn_instagram)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btn_dial -> {
                var intent = Intent()      //implicit intent
                intent.data = Uri.parse("tel:${et_number?.text.toString()}")
                intent.action = Intent.ACTION_DIAL
                startActivity(intent)

            }
            R.id.btn_welcome -> {
                var intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("myname", et_name?.text.toString())//putextra is used to transfer data
                startActivity(intent)

            }
            R.id.btn_youtube->
            {
                var youtubeintent=packageManager.getLaunchIntentForPackage("com.google.android.youtube")
                startActivity(youtubeintent)
            }
            R.id.btn_udemy->
            {
                var udemyintent=packageManager.getLaunchIntentForPackage("com.udemy.android")
                startActivity(udemyintent)
            }
            R.id.btn_instagram->
            {
                try {
                    var udemyintent=packageManager.getLaunchIntentForPackage("com.instagram.android")
                    startActivity(udemyintent)
                }catch(e:Exception)
                {
                  Toast.makeText(this,"please install instagram,it's not availlable",Toast.LENGTH_SHORT).show()
                    //logic to ask the user to install instagram (take user to download page)

                    var intent=Intent()
                    var url="https://play.google.com/store/apps/details?id=com.instagram.android"
                    intent.action=Intent.ACTION_VIEW
                   intent.data=Uri.parse(url)
                    startActivity(intent)
                }

            }

        }


    }
}