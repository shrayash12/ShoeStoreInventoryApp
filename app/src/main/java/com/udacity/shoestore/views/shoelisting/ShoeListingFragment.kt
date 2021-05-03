package com.udacity.shoestore.views.shoelisting

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.udacity.shoestore.R
import android.widget.LinearLayout as LinearLayout1

class ShoeListingFragment : Fragment(R.layout.shoelistingfragment) {
    lateinit var shoeListViewModel: ShoeListViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonAdd = view.findViewById<FloatingActionButton>(R.id.buttonAdd)

        val linearLayout = view.findViewById<LinearLayout1>(R.id.linearLayout)
        val scrollView = view.findViewById<ScrollView>(R.id.scrollViewParent)
        buttonAdd.setOnClickListener {
            Log.i("ShoeListingFragment", "button Clicked")
            Navigation.findNavController(it)
                .navigate(R.id.action_shoeListingFragment_to_shoeDetails)
        }

        shoeListViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        shoeListViewModel.shoesList.observe(requireActivity(), Observer {

            it.forEach {
                val view =
                    LayoutInflater.from(requireContext()).inflate(R.layout.list_item, scrollView, false)
                val imageView = view.findViewById<ImageView>(R.id.shoeImage)
                val shoeName = view.findViewById<TextView>(R.id.tvShoeName)
                val companyName = view.findViewById<TextView>(R.id.tvCompanyName)
                shoeName.text = it.name
                companyName.text = it.company
                linearLayout.addView(view)
            }


        })


    }


}
