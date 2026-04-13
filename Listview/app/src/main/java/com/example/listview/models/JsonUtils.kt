package com.example.listview.models

import android.content.Context
import org.json.JSONArray

object JsonUtils {

    fun loadProducts(context: Context): ArrayList<Product> {
        val productList = ArrayList<Product>()

        try {
            // đọc file JSON từ assets
            val jsonString = context.assets.open("products_with_images.json")
                .bufferedReader()
                .use { it.readText() }

            // chuyển thành JSONArray
            val jsonArray = JSONArray(jsonString)

            // lặp qua từng object
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)

                val product = Product(
                    id = obj.getInt("id"),
                    name = obj.getString("name"),
                    price = obj.getInt("price"),
                    description = obj.getString("description"),
                    image = obj.getString("image")
                )

                productList.add(product)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return productList
    }
}