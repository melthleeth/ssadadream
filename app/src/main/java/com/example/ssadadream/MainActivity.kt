package com.example.ssadadream

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.*

class MainActivity : AppCompatActivity() {
    // Fragment object 만들기
    lateinit var homeFragment:HomeFragment
    lateinit var myOrderFragment:MyOrderFragment
    lateinit var payFragment:PayFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.btm_nav)

        // default fragment가  home이라 항상 보여줄 것임


        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
            // fragment 동작하는 부분

                R.id.nav_home -> {
                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_main, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.nav_myorder -> {
                    myOrderFragment = MyOrderFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_main, myOrderFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.nav_pay -> {
                    payFragment = PayFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_main, payFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }

            true
        }
    }
}
