package com.example.mentorship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mentorship.features.fragmentsdemo.FragmentDemoActivity
import com.example.mentorship.databinding.ActivityMainBinding
import com.example.mentorship.features.forgotpassword.ForgotPasswordActivity
import com.example.mentorship.features.gallery.GalleryActivity
import com.example.mentorship.features.playeractivity.PlayerActivity
import com.example.mentorship.features.recyclerMultipleTypes.RecyclerMultipleTypesActivity
import com.example.mentorship.features.recyclerview.RecyclerActivity
import com.example.mentorship.features.todolist.ToDoListActivity
import com.example.mentorship.features.weatherwidget.WeatherWidgetActivity

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.forgotPasswordBtn.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        binding.toDoListBtn.setOnClickListener {
            startActivity(Intent(this, ToDoListActivity::class.java))
        }

        binding.weatherWidgetBtn.setOnClickListener {
            startActivity(Intent(this, WeatherWidgetActivity::class.java))
        }

        binding.playerActivityBtn.setOnClickListener {
            startActivity(Intent(this, PlayerActivity::class.java))
        }

        binding.fragmentsDemoBtn.setOnClickListener {
            startActivity(Intent(this, FragmentDemoActivity::class.java))
        }

        binding.recyclerDemoBtn.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }

        binding.recyclerMultipleTypesBtn.setOnClickListener {
            startActivity(Intent(this, RecyclerMultipleTypesActivity::class.java))
        }

        binding.galleryBtn.setOnClickListener {
            startActivity(Intent(this, GalleryActivity::class.java))
        }
    }
}