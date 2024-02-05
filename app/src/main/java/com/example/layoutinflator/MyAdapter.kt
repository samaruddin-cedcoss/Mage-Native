package com.example.layoutinflator

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.layoutinflator.Category
import com.example.layoutinflator.R
import de.hdodenhof.circleimageview.CircleImageView


class MyAdapter(private var context: Context , var categoryList: ArrayList<Category>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView= LayoutInflater.from(context).inflate(R.layout.category_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        var currentItem = categoryList[position]
        holder.categoryText.text= currentItem.categoryText
        holder.categoryImage.setImageResource(currentItem.categoryImage)

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView.findViewById<CircleImageView>(R.id.categoryImageView)
        val categoryText = itemView.findViewById<TextView>(R.id.categoryTextView)

    }

}
