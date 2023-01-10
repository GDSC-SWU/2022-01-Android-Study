package org.techtown.myblog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class ProfileAdapter2(private val context: Context):
RecyclerView.Adapter<ProfileAdapter2.ViewHolder>(){
    var datas = mutableListOf<ProfileData2>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):ViewHolder
    {
        val view= LayoutInflater.from(context).inflate(R.layout.item_recycler_ex2, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int=datas.size
    override fun onBindViewHolder(holder: ViewHolder, position:Int)
    {
        holder.bind(datas[position])
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val imgProfile2:ImageView= itemView.findViewById(R.id.popularphoto)
        private val txttitle:TextView = itemView.findViewById(R.id.title)
        private val little: TextView = itemView.findViewById(R.id.title)

        fun bind(item: ProfileData2){
            Glide.with(itemView).load(item.img).into(imgProfile2)
            txttitle.text = item.title.toString()
            little.text = item.little.toString()
        }
    }



}


