package com.example.listview.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import com.example.listview.R
import com.example.listview.adapter.ProductAdapter
import com.example.listview.base.BaseActivity
import com.example.listview.models.JsonUtils

class MainActivity : BaseActivity() {

    private lateinit var     listViewProducts: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar(R.id.toolbarMain, "Danh sách sản phẩm")

        listViewProducts = findViewById(R.id.listViewProducts)

        val productList = JsonUtils.loadProducts(this)
        listViewProducts.adapter = ProductAdapter(this, productList)

        listViewProducts.setOnItemClickListener { _, _, position, _ ->
            val product = productList[position]

            startActivity(Intent(this, DetailActivity::class.java).apply {
                putExtra("product", product)
            })
        }
    }
}