package com.example.mentorship.features.forgotpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mentorship.R
import com.example.mentorship.features.forgotpassword.ForgotPasswordActivity.Companion.KEY_NEW_PASSWORD

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)
        val message = intent.getStringExtra(
            KEY_NEW_PASSWORD)

        findViewById<TextView>(R.id.textView).apply {
            text = message
        }
    }

}