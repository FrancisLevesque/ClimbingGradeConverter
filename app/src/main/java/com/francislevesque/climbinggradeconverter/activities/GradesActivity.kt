package com.francislevesque.climbinggradeconverter.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.adapters.GradingSystemRecycleAdapter
import com.francislevesque.climbinggradeconverter.services.DataService
import com.francislevesque.climbinggradeconverter.utilities.*
import kotlinx.android.synthetic.main.activity_grades.*

class GradesActivity : AppCompatActivity() {

    private lateinit var adapter: GradingSystemRecycleAdapter
    private val selectText = "(please select a system)"

    // TODO: Add undo button to reselect first choice
    // TODO: For grayscaling images, do it in onBindViewHolder like GradeRecycleAdapter so we don't have recycled adapter items reusing the disabled colour by accident

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grades)

        val climbingType = intent.getStringExtra(EXTRA_CLIMBING_TYPE)
        val gradingSet = DataService.fetchGradingSet(climbingType)

        adapter = GradingSystemRecycleAdapter(this, gradingSet) { currentSelection ->
            gradeFromText.text = currentSelection.fromSystemName()
            gradeToText.text = selectText
            if (currentSelection.readyToConvert()) {
                gradeToText.text = currentSelection.toSystemName()
                val conversionIntent = Intent(this, ConvertActivity::class.java)
                conversionIntent.putExtra(EXTRA_FROM_SYSTEM, currentSelection.fromSystem)
                conversionIntent.putExtra(EXTRA_TO_SYSTEM, currentSelection.toSystem)
                conversionIntent.putExtra(EXTRA_CLIMBING_TYPE, climbingType)
                startActivity(conversionIntent)
            }
        }
        climbingSystemsView.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        climbingSystemsView.layoutManager = layoutManager
        climbingSystemsView.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        gradeToText.text = selectText
    }
}