package com.francislevesque.climbinggradeconverter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.models.GradingSystem

class GradingSystemRecycleAdapter(private val context: Context, private val gradingSystems: List<GradingSystem>) : RecyclerView.Adapter<GradingSystemRecycleAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gradingSystemImage = itemView.findViewById<ImageView>(R.id.gradingSystemImage)
        val gradingSystemText = itemView.findViewById<TextView>(R.id.gradingSystemText)
        val gradingSystemSubtext = itemView.findViewById<TextView>(R.id.gradingSystemSubtext)

        fun bindGradingSystem(gradingSystem: GradingSystem, context: Context) {
            val resourceId = context.resources.getIdentifier(
                gradingSystem.image,
                "drawable", context.packageName
            )
            gradingSystemImage.setImageResource(resourceId)
            gradingSystemText.text = gradingSystem.name
            gradingSystemSubtext.text = gradingSystem.subtext
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.grading_system_list_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return gradingSystems.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindGradingSystem(gradingSystems[position], context)
    }
}