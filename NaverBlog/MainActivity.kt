package org.techtown.myblog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_recycler_ex.*
import org.techtown.myblog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    //블로그 내용 recycler용 어댑터
    lateinit var profileAdapter:ProfileAdapter
    val datas = mutableListOf<ProfileData>()

    //인기글 내용 어댑터
    lateinit var profileAdapter2 : ProfileAdapter2
    val datass= mutableListOf<ProfileData2>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Myphoto.setOnClickListener{
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
        binding.findBtn.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        //뒤의 함수 호출
        initRecycler()
        initRecycler2()
       
    }
    private fun initRecycler(){
        profileAdapter = ProfileAdapter(this)
        rv_profile.adapter=profileAdapter
        datas.apply{
            add(ProfileData(date="2022. 10. 29.", reader="32읽음", img=R.drawable.food,title="파이널리",contents="파이널리 시험 끝!! 증말 공부를...",
                img2=R.drawable.heart,likenum="3",img3=R.drawable.malballon,malballonnum="1",img4=R.drawable.shared))
            add(ProfileData(date="2022. 10. 21.", reader="17읽음", img=R.drawable.food2,title="피곤할땐 레몬사탕이지",contents="별일 없는 시험기간...",
                img2=R.drawable.heart,likenum="2",img3=R.drawable.malballon,malballonnum="2",img4=R.drawable.shared))
            add(ProfileData(date="2022. 10. 17.", reader="11읽음", img=R.drawable.weather,title="웨더아웃사이드",contents="요즘 날씨 너무 좋다 내가 두번째로 좋아하는...",
                img2=R.drawable.heart,likenum="0",img3=R.drawable.malballon,malballonnum="0",img4=R.drawable.shared))
            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()
        }
    }
    private fun initRecycler2(){
        profileAdapter2 = ProfileAdapter2(this)
        rv_profile2.adapter = profileAdapter2
        datass.apply{
            add(ProfileData2(img=R.drawable.food, title="파이널리", little=""))
            add(ProfileData2(img=R.drawable.food2, title="피곤할땐 레몬사탕이지", little=""))
            add(ProfileData2(img=R.drawable.weather, title="밀린 일기 와장창", little=""))
            add(ProfileData2(img=R.drawable.my, title="웨더아웃사이드", little=""))

            profileAdapter2.datas = datass
            profileAdapter.notifyDataSetChanged()
        }
    }
}