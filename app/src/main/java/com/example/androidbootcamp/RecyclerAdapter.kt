package com.example.androidbootcamp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.DemoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoViewHolder {
        return DemoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false))
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: DemoViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class DemoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            with(itemView) {
                tv_title.text = "Title $position"
            }
        }
    }
}