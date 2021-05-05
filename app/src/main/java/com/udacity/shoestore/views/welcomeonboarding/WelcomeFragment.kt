package com.udacity.shoestore.views.welcomeonboarding

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R

class WelcomeFragment:Fragment(R.layout.welcomefragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonGo = view.findViewById<Button>(R.id.buttonGo)
        buttonGo.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_welcomeFragment_to_instructionFragment)
        }
        (activity as AppCompatActivity).supportActionBar?.title = "Welcome Screen"

    }
}