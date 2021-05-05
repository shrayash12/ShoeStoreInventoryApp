package com.udacity.shoestore.views.instruction

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R

class InstructionFragment : Fragment(R.layout.instructionsfragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonShoeStore = view.findViewById<Button>(R.id.buttonShoeStore)
        buttonShoeStore.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_instructionFragment_to_shoeListingFragment)
        }
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.instruction_screen)
    }
}