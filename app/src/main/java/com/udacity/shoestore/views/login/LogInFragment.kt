package com.udacity.shoestore.views.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.util.UserManager

class LogInFragment : Fragment(R.layout.loginfragment) {

    private lateinit var etEmailId: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogIn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Check if it is log in
        if (UserManager.getUserLogin(requireContext()).first.isNotEmpty()) {
            // Navigate to shoe list screen
            Navigation.findNavController(view)
                .navigate(R.id.action_logInFragment_to_shoeListingFragment)
        }
        etEmailId = view.findViewById(R.id.etEmailid)
        editTextPassword = view.findViewById(R.id.editTextPassword)
        buttonLogIn = view.findViewById(R.id.buttonLogIn)

        buttonLogIn.setOnClickListener {
            if (etEmailId.text.toString().isEmpty()) {
                return@setOnClickListener
            }
            if (editTextPassword.text.toString().isEmpty()) {
                return@setOnClickListener
            }
            UserManager.saveUserLogin(
                requireActivity(),
                etEmailId.text.toString(),
                editTextPassword.text.toString()
            )

            // Navigate to welcome screen
            Navigation.findNavController(it).navigate(R.id.action_logInFragment_to_welcomeFragment)
        }
    }

}