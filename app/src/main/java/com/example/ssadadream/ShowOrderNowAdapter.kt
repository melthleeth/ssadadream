package com.example.ssadadream

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter

class ShowOrderNowAdapter (fm : androidx.fragment.app.FragmentManager) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment? {
        return when (position) { //switch()문과 동일하다.
            0 -> ShowOrderNow_Others_tab()
            1 -> ShowOrderNow_Mine_tab()
            else -> null
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "주문진행상태"
            1 -> "신청현황"
            else -> null
        }
    }
}