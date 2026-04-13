package com.example.listview.models
import android.content.Context
import org.json.JSONArray

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(val id: Int,
                   val name: String,
                   val price: Int,
                   val description: String,
                   val image: String): Parcelable

