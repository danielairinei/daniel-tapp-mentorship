package com.example.mentorship.features.forgotpassword

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorship.R
import com.google.android.material.button.MaterialButton

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        findViewById<MaterialButton>(R.id.changePassBtn).setOnClickListener {
            sendPassword()
        }

    }

    private fun sendPassword() {
        val editText = findViewById<EditText>(R.id.userInput)
        val message = "Your new password is ${editText.text}"
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(KEY_NEW_PASSWORD, message)
        }
        startActivity(intent)
    }

    companion object {
        const val KEY_NEW_PASSWORD = "KEY_NEW_PASSWORD"
    }
}