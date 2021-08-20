package com.sample.loginapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.sample.loginapp.MainActivity
import com.sample.loginapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(Runnable {
            Intent(this@SplashActivity,MainActivity::class.java).also {
                startActivity(it)
                finish()
            }

        }, 2000)
    }
}