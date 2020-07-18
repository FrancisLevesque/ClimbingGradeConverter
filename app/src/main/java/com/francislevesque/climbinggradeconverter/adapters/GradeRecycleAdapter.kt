package com.francislevesque.climbinggradeconverter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.francislevesque.climbinggradeconverter.models.Grade

class GradeRecycleAdapter(private val context: Context, private val grades: List<Grade>) : RecyclerView.Adapter<GradeRecycleAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gradeText = itemView.findViewById<TextView>(android.R.id.text1)

        fun bindGrades(grade: Grade, context: Context) {
            gradeText.text = grade.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return grades.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindGrades(grades[position], context)
    }
}