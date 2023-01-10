package org.techtown.myblog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_recycler_ex.*
import org.techtown.myblog.databinding.ActivityMainBinding


class HomeFragment : Fragment() {

    private lateinit var adapter2: ProfileAdapter2
    private lateinit var recyclerView: RecyclerView
    private lateinit var profile2ArrayList:ArrayList<ProfileData2>

    private lateinit var adapter1:ProfileAdapter
    private lateinit var recyclerView2: RecyclerView
    private lateinit var datalist:ArrayList<ProfileData>

    lateinit var ImageId:Array<Int>
    lateinit var title:Array<String>
    lateinit var little:Array<String>

    lateinit var date:Array<String>
    lateinit var reader:Array<String>
    lateinit var content:Array<String>
    lateinit var likenum:Array<String>
    lateinit var reply:Array<String>
    lateinit var mainImg:Array<Int>
    lateinit var heart:Array<Int>
    lateinit var malballon:Array<Int>
    lateinit var shared:Array<Int>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        dataInitialize1()
        val layoutManager1 = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclerView = view.findViewById(R.id.rv_profile2)
        recyclerView.layoutManager = layoutManager1
        adapter2=ProfileAdapter2(profile2ArrayList)
        recyclerView.adapter = adapter2
        
        val layoutManager2 = LinearLayoutManager(context)
        recyclerView2 = view.findViewById(R.id.rv_profile)
        recyclerView2.layoutManager = layoutManager2
        adapter1 = ProfileAdapter(datalist)
        recyclerView2.adapter = adapter1

    }
    private fun dataInitialize(){
        profile2ArrayList= ArrayList<ProfileData2>()
        ImageId=arrayOf(
            R.drawable.food,
            R.drawable.food2,
            R.drawable.weather,
            R.drawable.my
        )
        title = arrayOf(
            getString(R.string.title1),
            getString(R.string.title2),
            getString(R.string.title4),
            getString(R.string.title3)
        )
        little = arrayOf(
            getString(R.string.title1),
            getString(R.string.title2),
            getString(R.string.title4),
            getString(R.string.title3)
        )
        for(i in ImageId.indices){
            val little = ProfileData2(ImageId[i], title[i],little[i])
            profile2ArrayList.add(little)
        }

    }
    private fun dataInitialize1(){
        datalist = ArrayList<ProfileData>()
        date= arrayOf(
            getString(R.string.date1),
            getString(R.string.date2),
            getString(R.string.date3)
        )
        reader= arrayOf(
            getString(R.string.reader1),
            getString(R.string.reader2),
            getString(R.string.reader3)
        )
        mainImg= arrayOf(
            R.drawable.food,
            R.drawable.my,
            R.drawable.weather
        )
        title= arrayOf(
            getString(R.string.title1),
            getString(R.string.title2),
            getString(R.string.title4)
        )
        content= arrayOf(
            getString(R.string.contents1),
            getString(R.string.contents2),
            getString(R.string.contents3)
        )
        heart=arrayOf(
            R.drawable.heart,
            R.drawable.heart,
            R.drawable.heart

        )
        likenum=arrayOf(
            getString(R.string.likenum1),
            getString(R.string.likenum2),
            getString(R.string.likenum3)
        )
        malballon = arrayOf(
            R.drawable.malballon,
            R.drawable.malballon,
            R.drawable.malballon
        )
        reply= arrayOf(
            getString(R.string.reply),
            getString(R.string.reply),
            getString(R.string.reply)
        )
        shared= arrayOf(
            R.drawable.shared,
            R.drawable.shared,
            R.drawable.shared
        )
        //여기 수정하기
        for(i in date.indices){
            val content = ProfileData(date[i], reader[i], mainImg[i], title[i], content[i], heart[i], likenum[i], malballon[i], reply[i], shared[i])
            datalist.add(content)
        }
    }


}