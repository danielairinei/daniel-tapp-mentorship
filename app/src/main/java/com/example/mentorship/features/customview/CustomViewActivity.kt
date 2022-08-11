package com.example.mentorship.features.customview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorship.databinding.ActivityCustomViewBinding
import com.example.mentorship.viewBinding

class CustomViewActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityCustomViewBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loadingBtn.setOnClickListener {
            binding.loadingBtn.isLoading = true
        }

        binding.submitPercentageBtn.setOnClickListener {
            refreshPercentage()
        }
    }

    private fun refreshPercentage() {
        binding.customPB.setPercentage(binding.percentageET.text.toString().toInt())
    }
}