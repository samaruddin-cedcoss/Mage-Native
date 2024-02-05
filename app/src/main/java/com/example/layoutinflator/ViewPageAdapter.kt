package com.example.layoutinflator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPageAdapter(val bannerViewList: ArrayList<ViewPage>): RecyclerView.Adapter<ViewPageAdapter.MyViewPageHolder>() {
    class MyViewPageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bannerImage = itemView.findViewById<ImageView>(R.id.bannerImage)
        val bannerTitle = itemView.findViewById<TextView>(R.id.bannerText)

        }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewPageAdapter.MyViewPageHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item,parent,false)
        return MyViewPageHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewPageAdapter.MyViewPageHolder, position: Int) {
        val currentItem = bannerViewList[position]
        holder.bannerImage.setImageResource(currentItem.image)
        holder.bannerTitle.text=currentItem.title
    }

    override fun getItemCount(): Int {
       return bannerViewList.size

    }
}