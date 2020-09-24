package com.francislevesque.climbinggradeconverter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.models.Grade
import com.francislevesque.climbinggradeconverter.services.DataService
import kotlinx.android.synthetic.main.grade_list_items.view.*


class GradeRecycleAdapter(private val context: Context, private val climbingType: String, private val fromGrades: List<Grade>, private val toGrades: List<Grade>) : RecyclerView.Adapter<GradeRecycleAdapter.Holder>() {
    var index = -1

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
        return DataService.fetchGradingCount(climbingType)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindGrades(fromGrades[position], toGrades[position], context)

        holder.itemView.setOnClickListener {
            index = position
            notifyDataSetChanged()
        }
        val color = context.getColor(DataService.fetchGradingColour(climbingType, position))
        holder.itemView.gradeRow.setBackgroundColor(color)

        if (position == index) {
            holder.itemView.fromBackground.setBackgroundColor(context.getColor(R.color.colorSelection))
            holder.itemView.toBackground.setBackgroundColor(context.getColor(R.color.colorSelectionAlt))
        } else {
            holder.itemView.fromBackground.setBackgroundColor(context.getColor(R.color.colorPrimaryDark))
            holder.itemView.toBackground.setBackgroundColor(context.getColor(R.color.colorPrimaryDark))
        }
    }
}