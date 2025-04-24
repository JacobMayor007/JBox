package com.example.jbox

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.jbox.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : Activity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize FirebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()

        // Find views
        val buttonLogin = findViewById<Button>(R.id.buttonSignIn)
        val mEmail = findViewById<EditText>(R.id.email)
        val mPassword = findViewById<EditText>(R.id.password)
        val registerButton = findViewById<TextView>(R.id.registeraccount)

        intent?.let {
            it.getStringExtra("email")?.let { email ->
                mEmail.setText(email)
            }
            it.getStringExtra("password")?.let { password ->
                mPassword.setText(password)
            }
        }

        // Set click listener for the login button
        buttonLogin.setOnClickListener {
            val email = mEmail.text.toString()
            val password = mPassword.text.toString()
            // Sign in with email and password
//            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
//                if (it.isSuccessful) {
//                    Toast.makeText(this, "Login Successfully!", Toast.LENGTH_SHORT).show()
//                    val intent = Intent(this, DashboardActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                }else{
//                    Toast.makeText(this, "Email and Password, is invalid", Toast.LENGTH_SHORT).show()
//                }
//            }
            val intent = Intent(this, DashboardActivity::class.java).apply {
                putExtra("email", email)
                putExtra("password", password)
            }
            Toast.makeText(this, "You have successfully, logged In", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()

        }

        registerButton.setOnClickListener {
            val intent = Intent (this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}