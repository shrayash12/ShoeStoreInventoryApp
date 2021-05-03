package com.udacity.shoestore.views.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R

class LogInFragment : Fragment(R.layout.loginfragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(LogInFragment::class.java.simpleName,"OnView Created")

        val buttonLogIn = view.findViewById<Button>(R.id.buttonLogIn)
        buttonLogIn.setOnClickListener {
            Log.d(LogInFragment::class.java.simpleName,"Button Click")

            Navigation.findNavController(it).navigate(R.id.action_logInFragment_to_welcomeFragment)
        }
    }

}