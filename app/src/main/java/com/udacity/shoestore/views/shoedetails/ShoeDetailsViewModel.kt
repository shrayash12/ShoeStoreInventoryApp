package com.udacity.shoestore.views.shoedetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailsViewModel : ViewModel() {
    val shoesList = MutableLiveData<List<Shoe>>()

    init {
        shoesList.value
    }

    fun addNewShoes(shoe: Shoe) {
        shoesList.value = listOf(shoe)
    }
}