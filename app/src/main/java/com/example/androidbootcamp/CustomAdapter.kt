package com.example.androidbootcamp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(val datavalues: ArrayList<CustomData>): RecyclerView.Adapter<AdapterClass.ViewHolder>() {


    //Viewholder
    inner class ViewHolder (itemView:View) : RecyclerView.ViewHolder(itemView){

        val titleView: TextView = itemView.findViewById(R.id.titleTextView1)
        val addressView: TextView = itemView.findViewById(R.id.subtitleTextView1)
        val imageView: ImageView = itemView.findViewById(R.id.imageView1)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar1)
        val noOfReviews: TextView = itemView.findViewById(R.id.reviews)
        val dateTextView: TextView = itemView.findViewById(R.id.textView)
        val amountTextView: TextView = itemView.findViewById(R.id.amount)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_list, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return datavalues.size
    }
    //Binds the view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleView.text = datavalues[position].title
        holder.addressView.text = datavalues[position].address
        holder.imageView.setImageResource(datavalues[position].imageID)
        holder.ratingBar.numStars = datavalues[position].StarRatings
        holder.noOfReviews.text = datavalues[position].noOfReview
        holder.dateTextView.text = datavalues[position].date
        holder.amountTextView.text = datavalues[position].amount
    }
}