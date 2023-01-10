package org.techtown.myblog

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Base64
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.databinding.adapters.AdapterViewBindingAdapter.setOnItemSelectedListener
import androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.setOnItemSelectedListener
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.techtown.myblog.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.MessageDigest


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    //@RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        //바틈네비 변수 실행
        //setonNavigationItemSelectedListener가 deprecated되었따
        val nav_bar = findViewById<BottomNavigationView>(R.id.nav_bar)
        nav_bar.setOnItemSelectedListener { item->
            changeFragment(
                when(item.itemId){
                    R.id.nav_one->{OneFragment()}
                    R.id.nav_two->{TwoFragment()}
                    R.id.nav_three->{ThreeFragment()}
                    R.id.nav_four->{FourFragment()}
                    else->{
                        HomeFragment()
                    }
                }
            )
            true
        }
        nav_bar.selectedItemId=R.id.nav_home


    }

    private fun changeFragment(fragment:Fragment ) {
        supportFragmentManager.beginTransaction().replace(R.id.nav_host, fragment)
            .commit()
    }

}