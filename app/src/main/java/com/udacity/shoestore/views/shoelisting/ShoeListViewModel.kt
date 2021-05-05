package com.udacity.shoestore.views.shoelisting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    val shoesList = MutableLiveData<ArrayList<Shoe>>()


    fun initiaseData() {
        val shoeBata = Shoe(
            "abc",
            2.0, "bata",
            "", emptyList()
        )
        val shoeNewBalance = Shoe(
            "NB",
            2.5, "NewBalance",
            "", emptyList()
        )
        val shoeNike = Shoe(
            "abc",
            5.0, "Nike",
            "", emptyList()
        )
        val shoeAdidas = Shoe(
            "Sneaker",
            5.0, "Adidas",
            "", emptyList()
        )
        shoesList.value = arrayListOf(shoeBata,shoeNewBalance, shoeNike,shoeAdidas)
    }
    fun addNewShoes(shoe: Shoe) {
        shoesList.value?.add(shoe)
    }


}