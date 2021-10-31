package com.example.androidbootcamp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbootcamp.roomdb.UserEntity
import kotlinx.android.synthetic.main.row_item.view.*

class RecyclerViewAdapter (val listener:RowClickListener):RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){

    var items = ArrayList<UserEntity>()

    fun setListData(data:ArrayList<UserEntity>){
        this.items = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return MyViewHolder(inflater , listener)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            listener.onItemClickListener(items[position])
        }
        holder.bind(items[position])

    }

    override fun getItemCount(): Int {

        return items.size   }

    class MyViewHolder(view: View , val listener: RowClickListener) :RecyclerView.ViewHolder(view){

        val tvName = view.tvName
        val tvEmail = view.tvEmail
        val tvphone = view.tvPhone

        val deleteUserId = view.deleteUserID
        fun bind(data:UserEntity){
            tvName.text = data.name
            tvEmail.text = data.email
            tvphone.text = data.phone
            deleteUserId.setOnClickListener{
                listener.onDeleteUserClick(data)
            }
        }
    }
    interface RowClickListener{
        fun onDeleteUserClick(user:UserEntity)
        fun onItemClickListener(user: UserEntity)
    }
}