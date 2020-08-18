package com.francislevesque.climbinggradeconverter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.utilities.EXTRA_CLIMBING_TYPE
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // TODO: Add a disclaimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boulderingButton.setOnClickListener {
            startActivity("bouldering")
        }
        climbingButton.setOnClickListener {
            startActivity("climbing")
        }
    }

    private fun startActivity(selection: String) {
        val climbingIntent = Intent(this, GradesActivity::class.java)
        climbingIntent.putExtra(EXTRA_CLIMBING_TYPE, selection)
        startActivity(climbingIntent)
    }
}
