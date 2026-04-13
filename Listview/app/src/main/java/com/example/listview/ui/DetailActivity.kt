package com.example.listview.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.listview.R
import com.example.listview.base.BaseActivity
import com.example.listview.models.Product

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val product = if (android.os.Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("product", Product::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Product>("product")
        }

        setupToolbar(R.id.toolbar, product?.name ?: "Chi tiết", true)

        setupUI(product)
    }

    private fun setupUI(product: Product?) {
        val imgDetail = findViewById<ImageView>(R.id.imgDetail)
        val txtDetailName = findViewById<TextView>(R.id.txtDetailName)
        val txtDetailPrice = findViewById<TextView>(R.id.txtDetailPrice)
        val txtDetailDescription = findViewById<TextView>(R.id.txtDetailDescription)

        txtDetailName.text = product?.name ?: ""
        txtDetailPrice.text = "%,d đ".format(product?.price ?: 0)
        txtDetailDescription.text = product?.description ?: ""

        imgDetail.load(product?.image) {
            crossfade(true)
        }
    }
}