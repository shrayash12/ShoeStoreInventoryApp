package com.udacity.shoestore.views.shoelisting

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListItemBinding
import com.udacity.shoestore.databinding.ShoelistingfragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.util.Constants
import com.udacity.shoestore.util.UserManager

class ShoeListingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoelistingfragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.shoelistingfragment, container, false)
        val shoe = arguments?.let {
            val name = it.getString(Constants.KEY_SHOE_NAME)
            val companyName = it.getString(Constants.KEY_COMPANY_NAME)
            val shoeSize = it.getString(Constants.KEY_SHOE_SIZE)
            val description = it.getString(Constants.KEY_SHOE_DESCRIPTION)
            Shoe(
                ObservableField(name ?: ""),
                ObservableField(shoeSize ?: ""),
                ObservableField(companyName ?: ""),
                ObservableField(description ?: "")
            )
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

    /*
    * Here we are dynamically creating view and adding it to LinearLayout i.e container
    * We could have use BindingAdapter but i need to get layoutInflater in BindingAdapter
    * */
    private fun createListView(
        it: ArrayList<Shoe>,
        scrollView: ScrollView?,
        linearLayout: android.widget.LinearLayout
    ) {
        it.forEach { shoe ->
            val listItemBinding = DataBindingUtil.inflate<ListItemBinding>(
                layoutInflater,
                R.layout.list_item,
                scrollView,
                false
            )
            listItemBinding.shoe = shoe
            linearLayout.addView(listItemBinding.root)
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
