package com.example.listview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.listview.R
import com.example.listview.models.Product

class ProductAdapter( private val context: Context, private val productList: List<Product>) : BaseAdapter() {

    override fun getCount(): Int = productList.size

    override fun getItem(position: Int): Any = productList[position]

    override fun getItemId(position: Int): Long = productList[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val product = productList[position]

        holder.txtName.text = product.name
        holder.txtPrice.text = "%,d đ".format(product.price)
        holder.txtDescription.text = product.description
        holder.imgProduct.load(product.image) {
            crossfade(true)
        }

        return view
    }
    private class   ViewHolder(view: View) {
        val imgProduct: ImageView = view.findViewById(R.id.imgProduct)
        val txtName: TextView = view.findViewById(R.id.txtName)
        val txtPrice: TextView = view.findViewById(R.id.txtPrice)
        val txtDesc ription: TextView = view.findViewById(R.id.txtDescription)
    }
}

//ListView cần hiển thị
//→ gọi getCount()
//→ gọi getView() từng item
//→ Adapter:
//- inflate layout
//- lấy dữ liệu
//- gán vào UI
//→ trả về view
//→ hiển thị lên màn hình