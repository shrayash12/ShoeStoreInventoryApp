package com.udacity.shoestore.views.shoelisting

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val shoesListLocal = MutableLiveData<ArrayList<Shoe>>()

    val shoesList: LiveData<ArrayList<Shoe>>
        get() = shoesListLocal

    fun initialiseData() {
        val shoeBata = Shoe(
            ObservableField("abc"),
            ObservableField("2.0"),
            ObservableField("Bata"),
            ObservableField("Affordable and Good"),
            emptyList()
        )
        val shoeNewBalance = Shoe(
            ObservableField("NB"),
            ObservableField("2.5"),
            ObservableField("NewBalance"),
            ObservableField("Nice Color and Comfortable"),
            emptyList()
        )
        val shoeNike = Shoe(
            ObservableField("NkShoe"),
            ObservableField("5.0"),
            ObservableField("Nike"),
            ObservableField("Best shoes for running"),
            emptyList()
        )
        val shoeAdidas = Shoe(
            ObservableField("Sneaker"),
            ObservableField("5.5"),
            ObservableField("Adidas"),
            ObservableField("Daily wear Sneaker"),
            emptyList()
        )
        val shoePuma = Shoe(
            ObservableField("Loafer"),
            ObservableField("5.5"),
            ObservableField("Puma"),
            ObservableField("Comfortable"),
            emptyList()
        )
        val shoeAldo = Shoe(
            ObservableField("Loafer"),
            ObservableField("5.5"),
            ObservableField("Aldo"),
            ObservableField("Stylish"),
            emptyList()
        )
        shoesListLocal.value =
            arrayListOf(shoeBata, shoeNewBalance, shoeNike, shoeAdidas, shoePuma, shoeAldo)
        arrayListOf(shoeBata)
    }

    fun addNewShoes(shoe: Shoe) {
        shoesListLocal.value?.add(shoe)
    }
}