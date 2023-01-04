package com.example.gdsc_myapp

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gdsc_myapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var currentTime : Long = System.currentTimeMillis()
    private var currentDateFormat = SimpleDateFormat("yyyyMMdd") // 년월일
    var currentDateString: String = currentDateFormat.format(currentTime)


    // Retrofit 객체 생성
    val retrofit: Retrofit
    get() = Retrofit.Builder()
        .baseUrl("http://apis.data.go.kr/1360000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 인터페이스 객체의 함수를 콜 -> 콜 객체 생성
        var networkService = retrofit.create(INetworkService::class.java)
        val call = networkService.doGetTemperList(
            "JSESSIONID=iH1gLnz4VD20YZKDgTSDykkO2sw7zgLfcx5sQtgSBUJ0MlTlbbA0R1iX4zYwgxX4.amV1c19kb21haW4vbmV3c2t5Mw==",
            "1",
            "JSON",
            "ASOS",
            "DAY",
            currentDateString,
            currentDateString,
            "108"
        )

        // enqueue()를 통해 네트워킹을 발생시키기 -> 콜백을 통해 결괏값을 얻어냄
        // 각각 콜백 함수의 로직을 작성
        call.enqueue(object: Callback<TemperListModel>{
            override fun onResponse(
                call: Call<TemperListModel>,
                response: Response<TemperListModel>
            ) {
                // val temperList = response.body()
                // val mutableList = mutableListOf<Map<String, String>>()
            }
            override fun onFailure(call: Call<TemperListModel>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        // 리사이클러뷰에 아이템 출력
        val todos = listOf(
            Todo("today's todo list #1", false),
            Todo("today's todo list #2", false),
            Todo("today's todo list #3", false),
            Todo("today's todo list #4", false),
            Todo("today's todo list #5", false),
        )
        // 아이템들을 어떻게 배열할지 정해줌 -> Linear: 세로로 나열
        binding.rv1.layoutManager = LinearLayoutManager(this)
        binding.rv1.adapter = TodoAdapter(todos)
        binding.rv2.layoutManager = LinearLayoutManager(this)
        binding.rv2.adapter = TodoAdapter(todos)
        binding.rv3.layoutManager = LinearLayoutManager(this)
        binding.rv3.adapter = TodoAdapter(todos)

        // 화면전환을 위한 intent 객체 생성
        val intentMyPage = Intent(this, MyPageActivity::class.java)

        binding.tvName.setOnClickListener{
            startActivity(intentMyPage)
        }
        binding.tvIntro.setOnClickListener{
            startActivity(intentMyPage)
        }
        // binding.tvAvgTemperNum.text = isNetworkAvailable()
    }

    // ConnectivityManager의 activeNetwork 프로퍼티를 가지고 Network 객체를 얻는 함수
    private fun isNetworkAvailable(): String {
        val manager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nw = manager.activeNetwork ?: return "offline"  // null이면 offline을 return
            val actNw = manager.getNetworkCapabilities(nw) ?: return "offline"
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return "wifi online"
                }
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return "cellular online"
                }
                else -> "offline"
            }
        }else {
            if(manager.activeNetworkInfo?.isConnected == true){
                return "online"
            }else {
                return "offline"
            }
        }
    }
}