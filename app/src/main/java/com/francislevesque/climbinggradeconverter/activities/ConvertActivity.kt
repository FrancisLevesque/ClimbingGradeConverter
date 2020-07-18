package com.francislevesque.climbinggradeconverter.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.models.GradingSystem
import com.francislevesque.climbinggradeconverter.utilities.*
import kotlinx.android.synthetic.main.activity_conversion.*

class ConvertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversion)

        val fromSystem = intent.getParcelableExtra<GradingSystem>(EXTRA_FROM_SYSTEM)
        val toSystem = intent.getParcelableExtra<GradingSystem>(EXTRA_TO_SYSTEM)

        fromTextTitle.text = fromSystem.name
        toTextTitle.text = toSystem.name
    }
}