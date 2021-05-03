package com.udacity.shoestore.views.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    val shoesList = MutableLiveData<List<Shoe>>()

    init {
        val shoeBata = Shoe(
           "abc",
           2.0, "bata",
           "", emptyList()
        )
        val shoeNike = Shoe(
           "abc",
           2.0, "Nike",
           "", emptyList()
        )
        shoesList.value = listOf(shoeBata, shoeNike)
    }

   fun addNewShoes(shoe: Shoe) {
      shoesList.value = listOf(shoe)
   }
}