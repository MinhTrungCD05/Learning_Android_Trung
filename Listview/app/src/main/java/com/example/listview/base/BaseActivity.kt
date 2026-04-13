package com.example.listview.base

import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


open class BaseActivity : AppCompatActivity() {

    fun setupToolbar(toolbarId: Int, title: String, showBack: Boolean = false) {
        val toolbar = findViewById<Toolbar>(toolbarId)
        setSupportActionBar(toolbar)
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(showBack)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun log(message: String) {
        Log.d("APP_DEBUG", message)
    }

    fun formatPrice(price: Int): String {
        return "%,d đ".format(price)
    }
}