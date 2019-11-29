package com.example.ssadadream

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_join_order.*

class JoinOrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //val thisintent = getIntent()
        //val sharedName = "additem"+ thisintent.getIntExtra("itemnum",777)
        //val shared: SharedPreferences = getSharedPreferences(sharedName, Context.MODE_PRIVATE)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_order)
        //val setCheckText = "주문번호 : " + shared.getInt("add_itemnum", 777) + "\n" + shared.getString("add_class","없음class") + " - " + shared.getString("add_spot","없음spot") + "\n주문 마감은 " + shared.getString("add_dead","없음dead") + " 까지\n" + shared.getString("add_meet","없음meet") + " 에\n" + shared.getString("add_arr","없음arr") + "에 도착 예정"
        //txtText.text = setCheckText

        btn_joinorder_no.setOnClickListener{
           // val nextIntent = Intent(this, AdditemActivity::class.java)
            //startActivity(nextIntent)
           finish()
        }

        btn_joinorder_yes.setOnClickListener{
            val nextIntent = Intent(this, Main2Activity::class.java)
            startActivity(nextIntent)
        }
    }
}