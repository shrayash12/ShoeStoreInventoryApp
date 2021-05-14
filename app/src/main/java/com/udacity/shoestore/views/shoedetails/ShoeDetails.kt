package com.udacity.shoestore.views.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoedetailsfragmentBinding
import com.udacity.shoestore.databinding.ShoedetailsfragmentBindingImpl
import com.udacity.shoestore.databinding.ShoelistingfragmentBinding
import com.udacity.shoestore.util.Constants
import kotlinx.android.synthetic.main.shoedetailsfragment.*

class ShoeDetails : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoedetailsfragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.shoedetailsfragment, container, false)
        binding.buttonCancel.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_shoeDetails_to_shoeListingFragment)
        }
       binding.buttonSave.setOnClickListener { view: View ->
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
            Navigation.findNavController(view)
                .navigate(R.id.action_shoeDetails_to_shoeListingFragment, bundle)
        }
        return binding.root

    }
}