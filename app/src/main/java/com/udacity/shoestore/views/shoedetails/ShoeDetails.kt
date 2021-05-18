package com.udacity.shoestore.views.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoedetailsfragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.util.Constants

class ShoeDetails : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val shoe = Shoe(
            ObservableField(""),
            ObservableField(""),
            ObservableField(""),
            ObservableField("")
        )

        val binding: ShoedetailsfragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.shoedetailsfragment, container, false)

        binding.shoe = shoe
        binding.buttonCancel.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_shoeDetails_to_shoeListingFragment)
        }
        binding.buttonSave.setOnClickListener { view: View ->
            val shoeName: String = shoe.name.get() ?: ""
            val companyName: String = shoe.company.get() ?: ""
            val shoeSize: String = shoe.size.get() ?: ""
            val shoeDescription: String = shoe.description.get() ?: ""

            val bundle = bundleOf(
                Constants.KEY_SHOE_NAME to shoeName,
                Constants.KEY_COMPANY_NAME to companyName,
                Constants.KEY_SHOE_SIZE to shoeSize,
                Constants.KEY_SHOE_DESCRIPTION to shoeDescription
            )
            Navigation.findNavController(view)
                .navigate(R.id.action_shoeDetails_to_shoeListingFragment, bundle)
        }
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.shoeDetail)
        return binding.root
    }

}