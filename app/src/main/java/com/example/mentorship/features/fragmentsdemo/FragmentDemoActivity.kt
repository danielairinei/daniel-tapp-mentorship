package com.example.mentorship.features.fragmentsdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorship.R
import com.example.mentorship.features.fragmentsdemo.fragments.ActionbarListenerFragment
import com.example.mentorship.databinding.ActivityFragmentDemoBinding
import com.example.mentorship.features.fragmentsdemo.fragments.LoginFragment
import com.example.mentorship.viewBinding

class FragmentDemoActivity : AppCompatActivity(), ActionbarListenerFragment {

    private val binding by viewBinding(ActivityFragmentDemoBinding::inflate)
    private val loginFragment = LoginFragment()
    private val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        manager.beginTransaction().replace(R.id.fragment_container, loginFragment).addToBackStack(null).commit()
    }

    override fun updateToolbar(newToolbarTextName: String) {
        title = newToolbarTextName
    }
}