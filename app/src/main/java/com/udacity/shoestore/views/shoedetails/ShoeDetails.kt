package com.udacity.shoestore.views.shoedetails

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.util.Constants

class ShoeDetails : Fragment(R.layout.shoedetailsfragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etShoeName = view.findViewById<EditText>(R.id.etShoeName)
        val etCompanyName = view.findViewById<EditText>(R.id.etCompanyName)
        val etShoeSize = view.findViewById<EditText>(R.id.etShoeSize)
        val etDescription = view.findViewById<EditText>(R.id.etDescription)
        val buttonCancel = view.findViewById<Button>(R.id.buttonCancel)
        val buttonSave = view.findViewById<Button>(R.id.buttonSave)

        buttonCancel.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_shoeDetails_to_shoeListingFragment)
        }
        buttonSave.setOnClickListener {
            val shoeName = etShoeName.text.toString()
            val companyName = etCompanyName.text.toString()
            val shoeSize = etShoeSize.text.toString()
            val shoeDescription = etDescription.text.toString()

            val bundle = bundleOf(
                Constants.KEY_SHOE_NAME to shoeName,
                Constants.KEY_COMPANY_NAME to companyName,
                Constants.KEY_SHOE_SIZE to shoeSize,
                Constants.KEY_SHOE_DESCRIPTION to shoeDescription
            )
            Navigation.findNavController(it)
                .navigate(R.id.action_shoeDetails_to_shoeListingFragment, bundle)

        }
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.shoe_details)
    }
}