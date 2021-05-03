package com.udacity.shoestore.views.shoedetails

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R

class ShoeDetails : Fragment(R.layout.shoedetailsfragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonCancel = view.findViewById<Button>(R.id.buttonCancel)
        val buttonSave = view.findViewById<Button>(R.id.buttonSave)
        buttonCancel.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_shoeDetails_to_shoeListingFragment)
        }
        buttonSave.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_shoeDetails_to_shoeListingFragment)

        }

    }
}