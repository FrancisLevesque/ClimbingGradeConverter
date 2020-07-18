package com.francislevesque.climbinggradeconverter.activities

import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.adapters.GradeRecycleAdapter
import com.francislevesque.climbinggradeconverter.models.GradingSystem
import com.francislevesque.climbinggradeconverter.utilities.*
import kotlinx.android.synthetic.main.activity_conversion.*

class ConvertActivity : AppCompatActivity() {

    private lateinit var fromAdapter: GradeRecycleAdapter
    private lateinit var toAdapter: GradeRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversion)

        val fromSystem = intent.getParcelableExtra<GradingSystem>(EXTRA_FROM_SYSTEM)
        val toSystem = intent.getParcelableExtra<GradingSystem>(EXTRA_TO_SYSTEM)

        fromTextTitle.text = fromSystem.name
        toTextTitle.text = toSystem.name

        // TODO: Create a new partial layout file and place both datasets into the same array adapter

        fromAdapter = GradeRecycleAdapter(this, fromSystem.dataset())
        fromList.adapter = fromAdapter
        val fromLayout = LinearLayoutManager(this)
        fromList.layoutManager = fromLayout

        toAdapter = GradeRecycleAdapter(this, toSystem.dataset())
        toList.adapter = toAdapter
        val toLayout = LinearLayoutManager(this)
        toList.layoutManager = toLayout
    }
}