package com.example.ssadadream

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_additem.*

class AdditemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var num = 0;    //주문마다 다른 name으로 저장하기 위한 변수...계속 증가해야하는데 어케해야할지 모르겠넹 디비 연결하면 그때 바꾸던지...
        val shared: SharedPreferences = getSharedPreferences("additem"+ num, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = shared.edit()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additem)

        btn_additem.setOnClickListener{
            editor.putInt("add_itemnum", num)
            editor.putString("add_class", add_spin_class.selectedItem.toString());
            editor.putString("add_spot", add_text_spot.text.toString())
            editor.putString("add_dead", add_text_dead.text.toString())
            editor.putString("add_meet", add_spin_spot.selectedItem.toString())
            editor.putString("add_arr", add_text_arrtime.text.toString())
            editor.commit()
            val nextIntent = Intent(this, AdditemPopUpActivity::class.java)
            nextIntent.putExtra("itemnum",num);
            num += 1    //이게..아닌데...
            startActivity(nextIntent)
        }
    }
}
