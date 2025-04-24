package com.example.jbox.register

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.jbox.LoginActivity
import com.example.jbox.R
import com.google.firebase.auth.FirebaseAuth


class RegisterActivity : Activity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firebaseAuth = FirebaseAuth.getInstance()

        val mEmail = findViewById<EditText>(R.id.emailreg)
        val mPassword = findViewById<EditText>(R.id.passwordreg)
        val mConPassword = findViewById<EditText>(R.id.confirmpasswordreg)
        val signUpButton = findViewById<TextView>(R.id.signup)

        signUpButton.setOnClickListener {
            val email = mEmail.text.toString()
            val password = mPassword.text.toString()
            val conPassword = mConPassword.text.toString()
            if(password == conPassword){
//                firebaseAuth.createUserWithEmailAndPassword(email, conPassword).addOnCompleteListener {
//                    if(it.isSuccessful){
//                        Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
//                        val intent = Intent(this, LoginActivity::class.java)
//                        startActivity(intent)
//                        finish()
//                    }
//                    else{
//                        Toast.makeText(this, "Signing up failed. Please double check email and password", Toast.LENGTH_SHORT).show()
//                    }
//                }

                val intent = Intent(this, LoginActivity::class.java).apply {
                    putExtra("email", email)
                    putExtra("password", password)
                }
                startActivity(intent)
            }else{
                Toast.makeText(this, "Password do not match", Toast.LENGTH_SHORT).show()
            }
        }

    }
}