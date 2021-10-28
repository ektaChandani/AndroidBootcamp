package com.example.androidbootcamp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbootcamp.databinding.ItemViewBinding

class RecyclerViewAdapter(private val data:List<DataModel>): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){


    inner class MyViewHolder(val binding: ItemViewBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:DataModel){
            binding.listitems = item


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = ItemViewBinding.inflate(inflater,parent,false)
        return MyViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
