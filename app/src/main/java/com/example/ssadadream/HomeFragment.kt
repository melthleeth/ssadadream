package com.example.ssadadream


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    val list1:ArrayList<String> = ArrayList()
    val list2:ArrayList<String> = ArrayList()
    val list3:ArrayList<String> = ArrayList()

    private lateinit var adapter1: HomeDataAdapter
    private lateinit var adapter2: HomeDataAdapter
    private lateinit var adapter3: HomeDataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater!!.inflate(R.layout.fragment_home, container, false)

        view.btn_add.setOnClickListener { view ->
            Toast.makeText(context, "주문 등록하기", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, AdditemActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val item_list1 = arrayListOf(
            HomeData("스타벅스", "산학협동관 1층", "11:45", "12:30", "7/7"),
            HomeData("차안유색", "경영관 1층", "12:20", "13:00", "4/7")
        )

        val item_list2 = arrayListOf(
            HomeData("서브웨이", "새천년관 1층", "12:00", "12:40", "4/4"),
            HomeData("차안유색", "경영관 1층", "13:10", "14:00", "2/4")
        )

        val item_list3 = arrayListOf(
            HomeData("GS25", "신공학관 1층", "9:30", "10:15", "4/4"),
            HomeData("CU", "도서관 3층입구", "10:45", "11:20", "1/4")
        )

        adapter1 = HomeDataAdapter(item_list1)
        recycle_list1.adapter = adapter1
        adapter1.notifyDataSetChanged()

        adapter2 = HomeDataAdapter(item_list2)
        recycle_list2.adapter = adapter2
        adapter2.notifyDataSetChanged()

        adapter3 = HomeDataAdapter(item_list3)
        recycle_list3.adapter = adapter3
        adapter3.notifyDataSetChanged()

        adapter1.itemClickListener = object: HomeDataAdapter.OnItemClickListener {
            override fun OnItemClick(
                holder: HomeDataAdapter.ViewHolder,
                view: View,
                data: HomeData,
                position: Int
            ) {
                val i = Intent(context, Home_listClicked::class.java)
                i.putExtra("name", data.d_name)
                startActivity(i)
            }
        }

        adapter2.itemClickListener = object: HomeDataAdapter.OnItemClickListener {
            override fun OnItemClick(
                holder: HomeDataAdapter.ViewHolder,
                view: View,
                data: HomeData,
                position: Int
            ) {
                val i = Intent(context, Home_listClicked::class.java)
                i.putExtra("name", data.d_name)
                startActivity(i)
            }
        }

        adapter3.itemClickListener = object: HomeDataAdapter.OnItemClickListener {
            override fun OnItemClick(
                holder: HomeDataAdapter.ViewHolder,
                view: View,
                data: HomeData,
                position: Int
            ) {
                val i = Intent(context, Home_listClicked::class.java)
                i.putExtra("name", data.d_name)
                startActivity(i)
            }
        }

    }
}