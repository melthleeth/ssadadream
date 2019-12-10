package com.example.ssadadream

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_additem.*

class AdditemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val orderNum = getSharedPreferences("orderNum", Context.MODE_PRIVATE)
        val edit = orderNum.edit()

        var num = 1+ orderNum.getInt("num",-1); //주문마다 다른 sharedpreference 이름으로 저장하기 위한 변수
        edit.putInt("num", num)   //주문 번호 갱신
        edit.commit()
        val shared: SharedPreferences = getSharedPreferences("additem"+ num, Context.MODE_PRIVATE) //주문마다 다른 sharedpreference 이름으로 저장
        val add_editor: SharedPreferences.Editor = shared.edit()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additem)

        btn_additem.setOnClickListener{ //각 항목 저장
            add_editor.putInt("add_itemnum", num)
            add_editor.putString("add_class", add_spin_class.selectedItem.toString());
            add_editor.putString("add_store", add_text_spot.text.toString())
            add_editor.putString("add_time_start", add_text_dead.text.toString())
            add_editor.putString("add_location", add_spin_spot.selectedItem.toString())
            add_editor.putString("add_time_end", add_text_arrtime.text.toString())
            add_editor.commit()
            val nextIntent = Intent(this, AdditemPopUpActivity::class.java)
            nextIntent.putExtra("itemnum",num);
            Toast.makeText(this, "주문번호 : "+ num, Toast.LENGTH_SHORT).show()
            startActivity(nextIntent)
        }
    }
}
