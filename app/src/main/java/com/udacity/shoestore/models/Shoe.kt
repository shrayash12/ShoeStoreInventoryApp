package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.ObservableField
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: ObservableField<String>,
    var size: ObservableField<String>,
    var company: ObservableField<String>,
    var description: ObservableField<String>,
    val images: List<String> = mutableListOf()
) : Parcelable