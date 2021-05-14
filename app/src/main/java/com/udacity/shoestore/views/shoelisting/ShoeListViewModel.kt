package com.udacity.shoestore.views.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val shoesListLocal = MutableLiveData<ArrayList<Shoe>>()

    val shoesList : LiveData<ArrayList<Shoe>>
        get() = shoesListLocal

    fun initialiseData() {
        val shoeBata = Shoe(
            "abc",
            2.0, "Bata",
            "Affordable and Good", emptyList()
        )
        val shoeNewBalance = Shoe(
            "NB",
            2.5, "NewBalance",
            "Nice Color and Comfortable", emptyList()
        )
        val shoeNike = Shoe(
            "Nike",
            5.0, "Nike",
            "Best shoes for running", emptyList()
        )
        val shoeAdidas = Shoe(
            "Sneaker",
            5.0, "Adidas",
            "Daily wear Sneaker", emptyList()
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
        shoesListLocal.value =
            arrayListOf(shoeBata, shoeNewBalance, shoeNike, shoeAdidas, shoePuma, shoeAldo)
    }

    fun addNewShoes(shoe: Shoe) {
        shoesListLocal.value?.add(shoe)
    }
}