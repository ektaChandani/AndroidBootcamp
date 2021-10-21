package com.example.androidbootcamp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbootcamp.Adapters.MyAdapter.MyViewHolder
import com.example.androidbootcamp.Models.Post
import com.example.androidbootcamp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_item.view.*

class MyAdapter(private val dataList : MutableList<Post>) : RecyclerView.Adapter<MyViewHolder>(){
    class MyViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView){
        var image:ImageView
        var txt_name : TextView
        var message : TextView

        init {
            image=itemView.profile_image
            txt_name=itemView.txt_name
            message=itemView.txt_message
        }

    }

private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item , parent , false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList[position]

        Picasso.get().load(dataList[position].profileImage).into(holder.image)
        holder.txt_name.text=dataList[position].name
        holder.message.text=dataList[position].message
    }

    override fun getItemCount(): Int {
        return dataList.size    }
}


