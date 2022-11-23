package com.example.gdsc_myapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdsc_myapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.fragmentView_main, homeFragment)
        transaction.commit()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    manager.beginTransaction().replace(R.id.fragmentView_main, homeFragment).commit()
                }
                R.id.profile -> {
                    manager.beginTransaction().replace(R.id.fragmentView_main, profileFragment).commit()
                }
            }
            true
        }
    }
}