package com.francislevesque.climbinggradeconverter.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.adapters.GradeRecycleAdapter
import com.francislevesque.climbinggradeconverter.models.GradingSystem
import com.francislevesque.climbinggradeconverter.utilities.*
import kotlinx.android.synthetic.main.activity_conversion.*

class ConvertActivity : AppCompatActivity() {

    private lateinit var gradesAdapter: GradeRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversion)

        val fromSystem = intent.getParcelableExtra<GradingSystem>(EXTRA_FROM_SYSTEM)
        val toSystem = intent.getParcelableExtra<GradingSystem>(EXTRA_TO_SYSTEM)
        val climbingType = intent.getStringExtra(EXTRA_CLIMBING_TYPE)

        fromTextTitle.text = fromSystem.name
        toTextTitle.text = toSystem.name

        gradesAdapter = GradeRecycleAdapter(this, climbingType, fromSystem.dataset(), toSystem.dataset())
        gradesList.adapter = gradesAdapter
        val gradesLayout = LinearLayoutManager(this)
        gradesList.layoutManager = gradesLayout
    }
}