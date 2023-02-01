package org.techtown.myblog

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class ProfileAdapter(private val datalist:ArrayList<ProfileData>):
        RecyclerView.Adapter<ProfileAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_ex,
        parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = datalist[position]
        holder.date.text = currentItem.date
        holder.reader.text = currentItem.reader
        holder.mainphoto.setImageResource(currentItem.img)
        holder.title.text = currentItem.title
        holder.content.text = currentItem.contents
        holder.heart.setImageResource(currentItem.img2)
        holder.likenum.text = currentItem.likenum
        holder.malballon.setImageResource(currentItem.img3)
        holder.reply.text = currentItem.malballonnum
        holder.shared.setImageResource(currentItem.img4)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val date:TextView = itemView.findViewById(R.id.textView2)
        val reader:TextView = itemView.findViewById(R.id.reader)
        val mainphoto:ImageView = itemView.findViewById(R.id.mainphoto)
        val title : TextView = itemView.findViewById(R.id.textview1)
        val content:TextView = itemView.findViewById(R.id.textView3)
        val heart:ImageView = itemView.findViewById(R.id.heart)
        val likenum:TextView = itemView.findViewById(R.id.likenum)
        val malballon:ImageView = itemView.findViewById(R.id.malballon)
        val reply:TextView = itemView.findViewById(R.id.textView4)
        val shared:ImageView = itemView.findViewById(R.id.shared)
    }
}


