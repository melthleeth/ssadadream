package com.example.ssadadream

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home_list_clicked.*

class Home_listClicked : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_list_clicked)

        init()
    }

    fun init() {
        val i = intent
        val name = i.getStringExtra("name")
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()

        order_title.text = name + "에서 주문하기"

        btn_order_F.setOnClickListener {
            finish()
        }

        btn_order_T.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, name + "에서 주문이 완료되었습니다.", Toast.LENGTH_SHORT).show()
        }

    }
}