package com.example.ssadadream

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeDataAdapter (var arr: ArrayList<HomeData>):
        RecyclerView.Adapter<HomeDataAdapter.ViewHolder>() {
    // 따로 만들어줘야 listview 처럼 사용 가능, 그리고 ViewHolder의 init block에서 초기화 해줘야함!!!
    interface OnItemClickListener {
        fun OnItemClick (holder: ViewHolder, view: View, data: HomeData, position: Int)
    }
    var itemClickListener:OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_homedata, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.v_name.text = arr[position].d_name.toString()
        holder.v_location.text = arr[position].d_location.toString()
        holder.v_time_start.text = arr[position].d_time_start.toString()
        holder.v_time_end.text = arr[position].d_time_end.toString()
        holder.v_people.text = arr[position].d_people.toString()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // val d_name:String, val d_location:String, val d_time_start:String, val d_time_end:String, val d_people:Int
        var v_name:TextView
        var v_location:TextView
        var v_time_start:TextView
        var v_time_end:TextView
        var v_people:TextView

        init {
            v_name = itemView.findViewById(R.id.txt_d_name)
            v_location = itemView.findViewById(R.id.txt_d_location)
            v_time_start = itemView.findViewById(R.id.txt_d_time_start)
            v_time_end = itemView.findViewById(R.id.txt_d_time_end)
            v_people = itemView.findViewById(R.id.txt_d_people)

            itemView.setOnClickListener {
                val position = adapterPosition
                itemClickListener?.OnItemClick(this, it, arr[position], position) }
        }
    }
}