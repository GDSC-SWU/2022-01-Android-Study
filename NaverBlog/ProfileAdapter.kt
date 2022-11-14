package org.techtown.myblog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProfileAdapter(private val context: Context):
RecyclerView.Adapter<ProfileAdapter.ViewHolder>(){
    var datas = mutableListOf<ProfileData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):ViewHolder
    {
        val view= LayoutInflater.from(context).inflate(R.layout.item_recycler_ex, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int=datas.size
    override fun onBindViewHolder(holder: ViewHolder, position:Int)
    {
        holder.bind(datas[position])
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val date : TextView = itemView.findViewById(R.id.textView2)
        private val reader: TextView = itemView.findViewById(R.id.reader)
        private val imgProfile: ImageView = itemView.findViewById(R.id.mainphoto)
        private val title : TextView = itemView.findViewById(R.id.textview1)
        private val contents : TextView = itemView.findViewById(R.id.textView3)
        private val heart: ImageView = itemView.findViewById(R.id.heart)
        private val likenum : TextView = itemView.findViewById(R.id.likenum)
        private val malballon: ImageView = itemView.findViewById(R.id.malballon)
        private val malballonnum : TextView = itemView.findViewById(R.id.textView4)
        val shared: ImageView = itemView.findViewById(R.id.shared)

        fun bind(item: ProfileData){
            date.text = item.date
            reader.text = item.reader
            Glide.with(itemView).load(item.img).into(imgProfile)
            title.text=item.title
            contents.text=item.contents
            Glide.with(itemView).load(item.img2).into(heart)
            likenum.text=item.likenum
            Glide.with(itemView).load(item.img3).into(malballon)
            malballonnum.text=item.malballonnum
            Glide.with(itemView).load(item.img4).into(shared)
        }
    }



}


