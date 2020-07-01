package com.francislevesque.climbinggradeconverter.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.adapters.GradingSystemRecycleAdapter
import com.francislevesque.climbinggradeconverter.services.DataService
import kotlinx.android.synthetic.main.bouldering_grades.*

class BoulderingGradesActivity : AppCompatActivity() {

    lateinit var adapter: GradingSystemRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bouldering_grades)

        adapter = GradingSystemRecycleAdapter(this, DataService.boulderSystems)
        boulderSystemsView.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        boulderSystemsView.layoutManager = layoutManager
        boulderSystemsView.setHasFixedSize(true)
    }
}