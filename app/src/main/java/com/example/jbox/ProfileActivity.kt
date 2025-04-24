package com.example.jbox

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : Activity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private var email: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        firebaseAuth = FirebaseAuth.getInstance()
        val settingsbutton = findViewById<TextView>(R.id.signout)
        settingsbutton.setOnClickListener {
           firebaseAuth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val user = firebaseAuth.currentUser

        user?.let {
            email = it.email ?: "No Email Found"
            findViewById<TextView>(R.id.emailname).text = email
        }
    }
}