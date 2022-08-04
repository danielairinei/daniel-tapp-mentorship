package com.example.mentorship.features.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mentorship.R
import com.example.mentorship.databinding.ActivityGalleryBinding
import com.example.mentorship.features.gallery.fragments.GalleryFragment
import com.example.mentorship.viewBinding

class GalleryActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityGalleryBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, GalleryFragment()).commit()
    }
}