package com.udacity.shoestore.views.shoelisting

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginfragmentBinding
import com.udacity.shoestore.databinding.ShoelistingfragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.util.Constants
import com.udacity.shoestore.util.UserManager
import kotlinx.android.synthetic.main.shoelistingfragment.*
import android.widget.LinearLayout as LinearLayout1

class ShoeListingFragment : Fragment() {
    private var root: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoelistingfragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.shoelistingfragment, container, false)
        val shoe = arguments?.let {
            val name = it.getString(Constants.KEY_SHOE_NAME)
            val companyName = it.getString(Constants.KEY_COMPANY_NAME)
            val shoeSize = it.getDouble(Constants.KEY_SHOE_SIZE)
            val description = it.getString(Constants.KEY_SHOE_DESCRIPTION)
            Shoe(name ?: "", shoeSize, companyName ?: "", description ?: "")
        }
        if (shoe != null) {
            shoeListViewModel.addNewShoes(shoe)
        }
        binding.buttonAdd.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_shoeListingFragment_to_shoeDetails)
        }
        shoeListViewModel.shoesList.observe(requireActivity(), Observer {
            createListView(it, binding.scrollViewParent, binding.linearLayout)
        })
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.shoe_list)
        return binding.root
    }

    lateinit var shoeListViewModel: ShoeListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    private fun createListView(
        it: ArrayList<Shoe>,
        scrollView: ScrollView?,
        linearLayout: android.widget.LinearLayout
    ) {
        it.forEach {
            val view =
                LayoutInflater.from(requireActivity())
                    .inflate(R.layout.list_item, scrollView, false)
            val imageView = view.findViewById<ImageView>(R.id.shoeImage)
            val shoeName = view.findViewById<TextView>(R.id.tvShoeName)
            val companyName = view.findViewById<TextView>(R.id.tvCompanyName)
            val shoeSize = view.findViewById<TextView>(R.id.tvShoeSize)
            val shoeDescriptions = view.findViewById<TextView>(R.id.tvShoeDescription)
            shoeName.text = it.name
            companyName.text = it.company
            shoeSize.text = it.size.toString()
            shoeDescriptions.text = it.description
            linearLayout.addView(view)
        }
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
        shoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        shoeListViewModel.initialiseData()
    }
}
