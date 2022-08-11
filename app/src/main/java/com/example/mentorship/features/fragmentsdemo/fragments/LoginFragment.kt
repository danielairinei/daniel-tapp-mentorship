package com.example.mentorship.features.fragmentsdemo.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mentorship.R
import com.example.mentorship.databinding.FragmentLoginBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val bundle: Bundle = Bundle()
    private lateinit var userFragment: UserFragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitFAB.setOnClickListener {
            userFragment = UserFragment()
            bundle.putString("email", binding.emailET.text.toString())
            bundle.putString("password", binding.passwordET.text.toString())
            userFragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                .replace(R.id.fragment_container, userFragment)
                .commit()
        }
    }
}