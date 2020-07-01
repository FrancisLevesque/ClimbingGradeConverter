package com.francislevesque.climbinggradeconverter.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.adapters.GradingSystemRecycleAdapter
import com.francislevesque.climbinggradeconverter.services.DataService
import kotlinx.android.synthetic.main.climbing_grades.*

class ClimbingGradesActivity : AppCompatActivity() {

    lateinit var adapter: GradingSystemRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.climbing_grades)

        adapter = GradingSystemRecycleAdapter(this, DataService.climbingSystems)
        climbingSystemsView.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        climbingSystemsView.layoutManager = layoutManager
        climbingSystemsView.setHasFixedSize(true)
    }
}