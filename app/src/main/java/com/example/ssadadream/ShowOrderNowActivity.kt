package com.example.ssadadream

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_showordernow.*

class ShowOrderNowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showordernow)

        val fragmentAdapter = ShowOrderNowAdapter(supportFragmentManager)
        odernow_viewpager.adapter = fragmentAdapter

        ordernow_tab.setupWithViewPager(odernow_viewpager)
    }
}
