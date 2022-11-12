package com.android.solution2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.android.solution2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var images: Array<Int> = arrayOf(R.drawable.dog1, R.drawable.dog2)

        var itemAdpater = ItemAdapter(images)

        binding.viewPager2.adapter = itemAdpater
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.ViewPager2.adapter = itemAdpater
        binding.ViewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.shop.setOnClickListener {
            val intent = Intent(this, ShopActivity::class.java)
            startActivity(intent)
        }

    }
}