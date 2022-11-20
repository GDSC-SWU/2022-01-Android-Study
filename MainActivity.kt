package com.android.solution3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.android.solution3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        val bottomBar = binding.bottomBar

        bottomBar.setOnItemSelectedListener { item ->
            changeFragment(
                when (item.itemId) {
                    R.id.first-> {
                        HomeFragment()
                    }
                    R.id.second-> {
                        SearchFragment()
                    }
                    R.id.third-> {
                        ReelsFragment()
                    }
                    R.id.fourth -> {
                        ShopFragment()
                    }
                    R.id.fifth -> {
                        ProfileFragment()
                    }
                    else -> {
                        HomeFragment()
                    }

                }
            )
            true
        }
        bottomBar.selectedItemId = R.id.first
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

}