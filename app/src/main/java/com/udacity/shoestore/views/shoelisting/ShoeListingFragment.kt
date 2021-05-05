package com.udacity.shoestore.views.shoelisting

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.util.UserManager
import android.widget.LinearLayout as LinearLayout1

class ShoeListingFragment : Fragment(R.layout.shoelistingfragment) {

    lateinit var shoeListViewModel: ShoeListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val buttonAdd = view.findViewById<FloatingActionButton>(R.id.buttonAdd)

        val linearLayout = view.findViewById<LinearLayout1>(R.id.linearLayout)
        val scrollView = view.findViewById<ScrollView>(R.id.scrollViewParent)


        val shoe = arguments?.let {
            val name = it.getString("shoeName")
            val companyName = it.getString("company")
            val shoeSize = it.getDouble("shoesSize")
            val description = it.getString("shoeDescription")
            Shoe(name ?: "", shoeSize, companyName ?: "", description ?: "")
        }

        if (shoe != null) {
            shoeListViewModel.addNewShoes(shoe)
        }

        buttonAdd.setOnClickListener {
            Log.i("ShoeListingFragment", "button Clicked")
            Navigation.findNavController(it)
                .navigate(R.id.action_shoeListingFragment_to_shoeDetails)
        }

        shoeListViewModel.shoesList.observe(requireActivity(), Observer {

            it.forEach {
                val view =
                    LayoutInflater.from(requireContext())
                        .inflate(R.layout.list_item, scrollView, false)
                val imageView = view.findViewById<ImageView>(R.id.shoeImage)
                val shoeName = view.findViewById<TextView>(R.id.tvShoeName)
                val companyName = view.findViewById<TextView>(R.id.tvCompanyName)
                shoeName.text = it.name
                companyName.text = it.company
                linearLayout.addView(view)
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
       inflater.inflate(R.menu.shoe_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                UserManager.logOut(requireContext())
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_shoeListingFragment_to_logInFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        shoeListViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        shoeListViewModel.initiaseData()
    }
}
