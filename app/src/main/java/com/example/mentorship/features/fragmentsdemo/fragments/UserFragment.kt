package com.example.mentorship.features.fragmentsdemo.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mentorship.R
import com.example.mentorship.databinding.FragmentUserBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class UserFragment : Fragment(R.layout.fragment_user) {

    private val binding by viewBinding(FragmentUserBinding::bind)
    private lateinit var passwordFragment: PasswordFragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.emailPlaceholderTV.text = arguments?.getString("email")
        binding.viewPasswordBtn.setOnClickListener {
            passwordFragment = PasswordFragment()
            passwordFragment.arguments = arguments
            requireActivity().supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                .replace(R.id.fragment_container, passwordFragment)
                //TODO: Not necessary now, but you should consider adding a name to transactions.
                //      If for example you want to pop a particular transaction from the back stack, you need a way to find it
                .addToBackStack(null).commit()
        }

        binding.updateToolbarBtn.setOnClickListener {
            updateToolbar(binding.updateToolbarET.text.toString())
        }

    }

    private fun updateToolbar(newToolBarText: String) {
        //TODO: Use safe casting and requireActivity
        //      val actionbarListenerFragment: ActionbarListenerFragment = (requireActivity() as? ActionbarListenerFragment) ?: return
        val actionbarListenerFragment: ActionbarListenerFragment = activity as ActionbarListenerFragment
        actionbarListenerFragment.updateToolbar(newToolBarText)
    }

    //TODO: Create companion object and add the keys and extension function mentioned in LoginFragment
}