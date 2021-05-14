package com.udacity.shoestore.views.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsfragmentBinding
import com.udacity.shoestore.databinding.WelcomefragmentBinding

class InstructionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: InstructionsfragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.instructionsfragment, container, false)
        binding.buttonShoeStore.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_instructionFragment_to_shoeListingFragment)
        }
        return binding.root
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.instruction_screen)

    }
}