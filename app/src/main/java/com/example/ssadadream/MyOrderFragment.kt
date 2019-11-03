package com.example.ssadadream


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_showordernow.*
import kotlinx.android.synthetic.main.fragment_others_tab.*
import androidx.fragment.app.FragmentActivity
import android.app.Activity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass.
 */
class MyOrderFragment : Fragment() {
    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_my_order, container, false)

//        val fragmentAdapter = ShowOrderNowAdapter(supportFragmentManager)
//        ordernow_tab.setupWithViewPager(ordernow_viewpager)

        // supportFM: main, childFM: 하위 fragment들 (오류 고쳐서 다행 ㅠ)
        viewPager = view.findViewById(R.id.ordernow_viewpager)
        tabs = view.findViewById(R.id.ordernow_tab)
        val fragmentAdapter = ShowOrderNowAdapter(childFragmentManager)
        viewPager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)

        return view
    }


}
