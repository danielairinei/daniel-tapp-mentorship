package com.example.mentorship.features.forgotpassword

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorship.R
import com.google.android.material.button.MaterialButton
//TODO: 1. Leave an empty line between class declaration and first method/field
//      Also an empty line between first method and fields
//      2. Remove the empty line at 20
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
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    companion object {
        //TODO: We prefer to declare keys as:
        //      const val KEY_NEW_PASSWORD = "KEY_NEW_PASSWORD"
        //      It's easier to understand what it is and what it is for
        const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
    }
}