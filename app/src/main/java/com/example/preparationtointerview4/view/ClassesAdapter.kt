package com.example.preparationtointerview4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.preparationtointerview4.R
import com.example.preparationtointerview4.model.Classes

class ClassesAdapter(var results : List<Classes>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ClasslistViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(position: Int) {

            val name = itemView.findViewById<TextView>(R.id.class_tv)
            name.text = results[position].name
            val time = itemView.findViewById<TextView>(R.id.timeStartEnd)
            time.text = results[position].time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ClasslistViewHolder(
            inflater.inflate(
                R.layout.item_class,
                parent,
                false
            ) as View
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ClasslistViewHolder
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return results.size
    }
}