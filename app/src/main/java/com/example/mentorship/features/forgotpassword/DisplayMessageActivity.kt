package com.example.mentorship.features.forgotpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mentorship.R
import com.example.mentorship.features.forgotpassword.ForgotPasswordActivity.Companion.EXTRA_MESSAGE

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        findViewById<TextView>(R.id.textView).apply {
            text = message
        }
    }
}