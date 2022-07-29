package com.example.mentorship.features.fragmentsdemo.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mentorship.R
import com.example.mentorship.databinding.FragmentLoginBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
//TODO: Leave an empty line between fields and first method
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    //TODO: No need to have a variable for a Bundle. Create a new one where you need to pass it
    private val bundle: Bundle = Bundle()
    //TODO: There's no need to have a variable for UserFragment. Simply instantiate it where you need to use it
    //      This ensures that you don't have leftover values for the arguments. Of course there may be moments when you need to keep it. This isn't one of them
    private lateinit var userFragment: UserFragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitFAB.setOnClickListener {
            userFragment = UserFragment()
            //TODO: Extract "email" and "password" to companion object constants. I think they should be in "UserFragment" since
            //      that's the fragment expecting them
            //      const val KEY_EMAIL = "KEY_EMAIL"
            bundle.putString("email", binding.emailET.text.toString())
            bundle.putString("password", binding.passwordET.text.toString())
            userFragment.arguments = bundle
            //TODO: Since UserFragment requires arguments, you may want to create an extension function that provides the instance
            //      fun UserFragment.newInstance(email: String, password: String): UserFragment =
            //          UserFragment().apply {
            //              arguments = Bundle().apply {
            //                  putString(KEY_EMAIL, binding.emailET.text.toString())
            //                  putString(KEY_PASSWORD, binding.passwordET.text.toString())
            //              }
            //          }
            //      This lets UserFragment handle how it is instantiated and what it requires.
            requireActivity().supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                .replace(R.id.fragment_container, userFragment)
                .addToBackStack(null).commit()
        }
    }
}