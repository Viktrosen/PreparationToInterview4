package com.example.preparationtointerview4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.preparationtointerview4.R
import com.example.preparationtointerview4.model.Homework

class HomeworkAdapter(val homework: List<Homework>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class HomeworkViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(position: Int) {

            val name = itemView.findViewById<TextView>(R.id.class_tv_homework)
            name.text = homework[position].nameOfClass
            val time = itemView.findViewById<TextView>(R.id.timeHomework)
            time.text = homework[position].date
            val textHW = itemView.findViewById<TextView>(R.id.textHomework)
            textHW.text = homework[position].textOfHomework
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return HomeworkViewHolder(
            inflater.inflate(
                R.layout.item_homework,
                parent,
                false
            ) as View
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as HomeworkViewHolder
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return homework.size
    }
}