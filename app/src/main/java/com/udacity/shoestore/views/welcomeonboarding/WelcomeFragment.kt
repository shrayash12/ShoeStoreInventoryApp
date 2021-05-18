package com.udacity.shoestore.views.welcomeonboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomefragmentBinding

class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: WelcomefragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.welcomefragment, container, false)
        binding.buttonGo.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_welcomeFragment_to_instructionFragment)
        }
        return binding.root
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.welcome_screen)
    }
}