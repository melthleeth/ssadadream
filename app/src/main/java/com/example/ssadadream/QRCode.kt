package com.example.ssadadream

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class QRCode : AppCompatActivity() {

    private var btn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_pay)

        //tvresult = findViewById(R.id.tvresult) as TextView

        btn = findViewById(R.id.btnScan) as Button

        btn!!.setOnClickListener {
            val intent = Intent(this, ScanActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

    }

    companion object {

        var tvresult: TextView? = null
    }
}
