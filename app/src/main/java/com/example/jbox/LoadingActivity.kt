package com.example.jbox

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.google.firebase.auth.FirebaseAuth


class LoadingActivity : Activity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        val handler = Handler(Looper.getMainLooper())

        handler.postDelayed({
               val intent = Intent(this, LoginActivity::class.java)
               startActivity(intent)
            finish()
        }, 5000)
    }
}