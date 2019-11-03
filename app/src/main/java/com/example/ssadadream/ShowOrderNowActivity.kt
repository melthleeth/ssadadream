package com.example.ssadadream

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_showordernow.*
import kotlinx.android.synthetic.main.fragment_others_tab.*

class ShowOrderNowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showordernow)

        val fragmentAdapter = ShowOrderNowAdapter(supportFragmentManager)
        ordernow_viewpager.adapter = fragmentAdapter

        ordernow_tab.setupWithViewPager(ordernow_viewpager)
    }
}
