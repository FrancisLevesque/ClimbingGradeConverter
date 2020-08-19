package com.francislevesque.climbinggradeconverter.adapters

import android.content.Context
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.models.GradingSystem
import com.francislevesque.climbinggradeconverter.services.DataService
import kotlinx.android.synthetic.main.grade_list_items.view.*

class GradingSystemRecycleAdapter(private val context: Context, private val gradingSystems: List<GradingSystem>, private val gradeClick : (Unit) -> Unit) : RecyclerView.Adapter<GradingSystemRecycleAdapter.Holder>() {
    var convertIsStaged = false
    var convertIsReady = false
    lateinit var fromSystem : GradingSystem
    lateinit var toSystem : GradingSystem
    var index = -1

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gradingSystemImage = itemView.findViewById<ImageView>(R.id.gradingSystemImage)
        val gradingSystemText = itemView.findViewById<TextView>(R.id.gradingSystemText)
        val gradingSystemSubtext = itemView.findViewById<TextView>(R.id.gradingSystemSubtext)

        fun bindGradingSystem(currentGradingSystem: GradingSystem, context: Context) {
            val resourceId = context.resources.getIdentifier(
                currentGradingSystem.image,
                "drawable", context.packageName
            )
            gradingSystemImage.setImageResource(resourceId)
            gradingSystemText.text = currentGradingSystem.name
            gradingSystemSubtext.text = currentGradingSystem.subtext
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

    fun readyToConvert() : Boolean {
        return convertIsReady
    }

    fun fromSystemName() : String? {
        return fromSystem.name
    }

    fun toSystemName() : String? {
        return toSystem.name
    }

    fun setGrayscale(image: ImageView) {
        val grayscale = ColorMatrix()
        grayscale.setSaturation(0F)
        image.colorFilter = ColorMatrixColorFilter(grayscale)
    }

    fun unsetGrayscale(image: ImageView) {
        image.clearColorFilter()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val currentGradingSystem = gradingSystems[position]
        holder.bindGradingSystem(currentGradingSystem, context)

        holder.itemView.setOnClickListener {
            index = position
            if (convertIsStaged) {
                if (currentGradingSystem == fromSystem) {
                    Toast.makeText(context, "Grading System already selected", Toast.LENGTH_SHORT).show()
                } else {
                    toSystem = currentGradingSystem
                    convertIsReady = true
                }
            } else {
                fromSystem = currentGradingSystem
                convertIsStaged = true
            }
            gradeClick.invoke(Unit)
            notifyDataSetChanged()
        }

        if (!convertIsReady) {
            val image= holder.itemView.findViewById<ImageView>(R.id.gradingSystemImage)
            if (position == index) {
                setGrayscale(image)
            } else {
                unsetGrayscale(image)
            }
        }
    }
}