package com.example.ssadadream

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Context
import android.content.SharedPreferences
import kotlinx.android.synthetic.main.activity_additempopup.*
import kotlinx.android.synthetic.main.activity_qrresult.*


class QRResult : AppCompatActivity() {

    private var btn: Button? = null
    var tvresult: TextView? = null

    //val thisintent = getIntent()
    //val sharedName = "additem"+ thisintent.getIntExtra("itemnum",777)
    //val shared: SharedPreferences = getSharedPreferences(sharedName, Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrresult)

        tvresult = findViewById(R.id.tvresult) as TextView

        //val setCheckText = "주문번호 : " + shared.getInt("add_itemnum", 777) + "\n" + shared.getString("add_class","없음class") + " - " + shared.getString("add_spot","없음spot") + "\n주문 마감은 " + shared.getString("add_dead","없음dead") + " 까지\n" + shared.getString("add_meet","없음meet") + " 에\n" + shared.getString("add_arr","없음arr") + "에 도착 예정"
        //txtText.text = setCheckText

        btn_personalpay_no.setOnClickListener{
            // val nextIntent = Intent(this, AdditemActivity::class.java)
            //startActivity(nextIntent)
            finish()
        }

        btn_personalpay_yes.setOnClickListener{
            val nextIntent = Intent(this, Main2Activity::class.java)
            startActivity(nextIntent)
        }
    }



    companion object {

        var tvresult: TextView? = null
    }

}
