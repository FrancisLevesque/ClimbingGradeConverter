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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grades)

        val climbingType = intent.getStringExtra(EXTRA_CLIMBING_TYPE)
        val gradingSet = DataService.fetchGradingSet(climbingType)

        adapter = GradingSystemRecycleAdapter(this, gradingSet) {
            gradeFromText.text = adapter.fromSystemName()
            gradeToText.text = selectText
            if (adapter.readyToConvert()) {
                gradeToText.text = adapter.toSystemName()
                val conversionIntent = Intent(this, ConvertActivity::class.java)
                conversionIntent.putExtra(EXTRA_FROM_SYSTEM, adapter.fromSystem)
                conversionIntent.putExtra(EXTRA_TO_SYSTEM, adapter.toSystem)
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
        adapter.convertIsReady = false
    }
}