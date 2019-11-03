package com.example.ssadadream


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_others_tab.*
import kotlinx.android.synthetic.main.fragment_others_tab.view.*

/**
 * A simple [Fragment] subclass.
 */
class ShowOrderNow_Others_tab : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//
//        return inflater.inflate(R.layout.fragment_others_tab, container, false)
        val view: View = inflater!!.inflate(R.layout.fragment_others_tab, container, false)

        view.btn_ordernow_others.setOnClickListener { view ->
            Toast.makeText(context, "모든 제품을 수령하였습니다!", Toast.LENGTH_LONG).show()
            val intent = Intent (context, MainActivity::class.java)
            startActivity(intent)
        }

        // Return the fragment view/layout
        return view
    }

}
