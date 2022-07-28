package com.example.mentorship.features.fragmentsdemo.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.mentorship.R
import com.example.mentorship.databinding.FragmentPasswordBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class PasswordFragment : Fragment(R.layout.fragment_password) {

    private val binding by viewBinding(FragmentPasswordBinding::bind)
    private var onBackPressed: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.passwordTV.text = arguments?.getString("password")

        binding.submitNewPasswordBtn.setOnClickListener {
            val newPassword = binding.changePasswordEt.text.toString()
            changePassword(newPassword)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (onBackPressed) {
                    parentFragmentManager.popBackStack()

                }
                onBackPressed = true
                Toast.makeText(activity, R.string.fragment_back_navigation_toast_description, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun changePassword(newPassword: String) {
        binding.changePasswordEt.setText("")
        binding.passwordTV.text = newPassword
        arguments?.putString("password", newPassword)
    }

}