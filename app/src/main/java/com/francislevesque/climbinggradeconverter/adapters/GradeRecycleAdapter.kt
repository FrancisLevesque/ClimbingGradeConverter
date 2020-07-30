package com.francislevesque.climbinggradeconverter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.models.Grade

class GradeRecycleAdapter(private val context: Context, private val fromGrades: List<Grade>, private val toGrades: List<Grade>) : RecyclerView.Adapter<GradeRecycleAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fromGradeText = itemView.findViewById<TextView>(R.id.fromGrade)
        val toGradeText = itemView.findViewById<TextView>(R.id.toGrade)

        fun bindGrades(fromGrade: Grade, toGrade: Grade, context: Context) {
            fromGradeText.text = fromGrade.name
            toGradeText.text = toGrade.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.grade_list_items, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        // All systems are currently broken into 35 parts in DataService
        // This can be refactored if it ever looks like that'll change
        return 35
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindGrades(fromGrades[position], toGrades[position], context)
    }
}