package com.francislevesque.climbinggradeconverter.adapters

import android.content.Context
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.models.GradingSystem

class GradingSystemRecycleAdapter(private val context: Context, private val gradingSystems: List<GradingSystem>, private val gradeClick : (Holder) -> Unit) : RecyclerView.Adapter<GradingSystemRecycleAdapter.Holder>() {
    var convertIsStaged = false
    var convertIsReady = false
    var selectedImage = ImageView(context)
    lateinit var selectedSystem : GradingSystem

    inner class Holder(itemView: View, val gradeClick: (Holder) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val gradingSystemImage = itemView.findViewById<ImageView>(R.id.gradingSystemImage)
        val gradingSystemText = itemView.findViewById<TextView>(R.id.gradingSystemText)
        val gradingSystemSubtext = itemView.findViewById<TextView>(R.id.gradingSystemSubtext)

        lateinit var toSystem : GradingSystem
        lateinit var fromSystem : GradingSystem

        fun readyToConvert() : Boolean {
            return convertIsReady
        }

        fun fromSystemName() : String? {
            return selectedSystem.name
        }

        fun bindGradingSystem(currentGradingSystem: GradingSystem, context: Context) {
            val resourceId = context.resources.getIdentifier(
                currentGradingSystem.image,
                "drawable", context.packageName
            )
            gradingSystemImage.setImageResource(resourceId)
            gradingSystemText.text = currentGradingSystem.name
            gradingSystemSubtext.text = currentGradingSystem.subtext
            itemView.setOnClickListener {
                if (convertIsStaged) {
                    toSystem = currentGradingSystem
                    fromSystem = selectedSystem
                    convertIsReady = true
                } else {
                    unsetGrayscale(selectedImage)
                    selectedImage = gradingSystemImage
                    selectedSystem = currentGradingSystem
                    setGrayscale(selectedImage)
                    convertIsStaged = true
                }
                gradeClick(this)
            }
        }
    }

    fun setGrayscale(image: ImageView) {
        val grayscale = ColorMatrix()
        grayscale.setSaturation(0F)
        image.colorFilter = ColorMatrixColorFilter(grayscale)
    }

    fun unsetGrayscale(image: ImageView) {
        image.clearColorFilter()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.grading_system_list_item, parent, false)
        return Holder(view, gradeClick)
    }

    override fun getItemCount(): Int {
        return gradingSystems.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindGradingSystem(gradingSystems[position], context)
    }
}