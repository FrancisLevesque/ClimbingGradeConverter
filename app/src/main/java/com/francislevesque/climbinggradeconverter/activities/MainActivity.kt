package com.francislevesque.climbinggradeconverter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.francislevesque.climbinggradeconverter.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boulderingSelected.setOnClickListener {
            val climbingIntent = Intent(this, BoulderingGradesActivity::class.java)
            startActivity(climbingIntent)
        }
        climbingSelected.setOnClickListener {
            val climbingIntent = Intent(this, ClimbingGradesActivity::class.java)
            startActivity(climbingIntent)
        }
    }
}
