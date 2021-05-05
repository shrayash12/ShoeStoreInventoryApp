package com.udacity.shoestore.views.shoelisting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    val shoesList = MutableLiveData<ArrayList<Shoe>>()


    fun initialiseData() {
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
        val shoePuma = Shoe(
            "Loafer",
            5.5, "Puma",
            "Comfortable", emptyList()
        )
        val shoeAldo = Shoe(
            "Loafer",
            4.5, "Aldo",
            "Stylish", emptyList()
        )
        shoesList.value =
            arrayListOf(shoeBata, shoeNewBalance, shoeNike, shoeAdidas, shoePuma, shoeAldo)
    }

    fun addNewShoes(shoe: Shoe) {
        shoesList.value?.add(shoe)
    }


}