package com.example.jbox

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : Activity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private var useremail:String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val profilebutton = findViewById<ImageView>(R.id.profileicon)
        val homebutton = findViewById<ImageView>(R.id.homeicon)
        val settingsbutton = findViewById<ImageView>(R.id.settingsicon)

//        firebaseAuth = FirebaseAuth.getInstance();
//
//        val user = firebaseAuth.currentUser
//
//        if(user == null){
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }

        intent?.let {
            it.getStringExtra("email")?.let { email->
                useremail = email
            }
        }

        Toast.makeText(this, "Welcome $useremail", Toast.LENGTH_SHORT).show()
        profilebutton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
        homebutton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
        settingsbutton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}