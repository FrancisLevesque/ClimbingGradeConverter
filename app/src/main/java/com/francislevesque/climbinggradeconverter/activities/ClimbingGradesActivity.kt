package com.francislevesque.climbinggradeconverter.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.adapters.GradingSystemRecycleAdapter
import com.francislevesque.climbinggradeconverter.services.DataService
import com.francislevesque.climbinggradeconverter.utilities.*
import kotlinx.android.synthetic.main.climbing_grades.*

class ClimbingGradesActivity : AppCompatActivity() {

    lateinit var adapter: GradingSystemRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.climbing_grades)

        adapter = GradingSystemRecycleAdapter(this, DataService.climbingSystems) { currentSelection ->
            gradeFrom.text = "Grade to convert FROM: ${currentSelection.fromSystemName()}\nSelect a grade to convert TO:"
            if (currentSelection.readyToConvert()) {
                val conversionIntent = Intent(this, ConvertActivity::class.java)
                conversionIntent.putExtra(EXTRA_FROM_SYSTEM, currentSelection.fromSystem)
                conversionIntent.putExtra(EXTRA_TO_SYSTEM, currentSelection.toSystem)
                startActivity(conversionIntent)
            }
        }
        climbingSystemsView.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        climbingSystemsView.layoutManager = layoutManager
        climbingSystemsView.setHasFixedSize(true)
    }
}