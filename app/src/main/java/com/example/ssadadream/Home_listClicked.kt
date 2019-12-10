package com.example.ssadadream

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home_list_clicked.*

class Home_listClicked : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val orderBefore = getSharedPreferences("OrderBefore", Context.MODE_PRIVATE)
        val OBedit = orderBefore.edit()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_list_clicked)

        val i = intent
        val name = i.getStringExtra("name")
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()

        order_name.setText(orderBefore.getString("OB_menu", "메뉴를 입력해주세요"))
        order_contents.setText(orderBefore.getString("OB_request", "추가 요청 사항을 적어주세요 \n (예시 : 15cm/위트/랜치, 스위트어니언/오이빼주세요)"))
        order_title.text = name + "에서 주문하기"

        btn_order_F.setOnClickListener {
            finish()
        }

        btn_order_T.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, name + "에서 주문이 완료되었습니다.", Toast.LENGTH_SHORT).show()
            OBedit.putString("OB_menu", order_name.text.toString())
            OBedit.putString("OB_request", order_contents.text.toString())
            OBedit.commit()
        }
    }
}