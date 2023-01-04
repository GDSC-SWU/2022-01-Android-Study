package com.example.gdsc_myapp

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gdsc_myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        val intentMyPage = Intent(this, MyPageActivity::class.java)

        binding.tvName.setOnClickListener{
            startActivity(intentMyPage)
        }
        binding.tvIntro.setOnClickListener{
            startActivity(intentMyPage)
        }
        binding.tvAvgTemperNum.text = isNetworkAvailable()
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