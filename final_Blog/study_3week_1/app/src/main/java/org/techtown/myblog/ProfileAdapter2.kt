package org.techtown.myblog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter2(private val profiledatalist: ArrayList<ProfileData2>):
    RecyclerView.Adapter<ProfileAdapter2.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_ex2,
            parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = profiledatalist[position]
        //img title little
        holder.titleimg.setImageResource(currentItem.img)
        holder.title.text = currentItem.title
        holder.little.text = currentItem.little
    }

    override fun getItemCount(): Int {
        return profiledatalist.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleimg:ImageView = itemView.findViewById(R.id.popularphoto)
        val title:TextView = itemView.findViewById(R.id.title)
        val little:TextView = itemView.findViewById(R.id.little)
    }
}


