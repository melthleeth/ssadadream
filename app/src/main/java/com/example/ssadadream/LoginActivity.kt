package com.example.ssadadream

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {

            val check = getSharedPreferences("login", Context.MODE_PRIVATE)
            val move = check.edit()
            move.putInt("FirstorNot", 1)    //로그인 전, 회원가입만 한 상태
            move.commit()

            val intent = Intent(this, Main2Activity::class.java)
            // start your next activity
            startActivity(intent)
        }

    }
}
