package com.udacity.shoestore.views.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsfragmentBinding
import com.udacity.shoestore.util.UserManager

class InstructionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // On boarding is completed. Show only for first time after login
        UserManager.setOnBoardingCompleted(true, requireContext())
        val binding: InstructionsfragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.instructionsfragment, container, false)
        binding.buttonShoeStore.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_instructionFragment_to_shoeListingFragment)
        }
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.instruction_screen)
        return binding.root
    }
}