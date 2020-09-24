package com.francislevesque.climbinggradeconverter.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.utilities.DISCLAIMER_KEY
import com.francislevesque.climbinggradeconverter.utilities.EXTRA_CLIMBING_TYPE
import com.francislevesque.climbinggradeconverter.utilities.SHARED_PREFERENCES_DOMAIN
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // TODO: Bug -> Select Kurtyka, then YDS -> go back -> YDS not gray (expected) -> scroll down -> Kurtyka not gray (not expected) -> scroll up -> YDS gray (not expected)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = this.getSharedPreferences(SHARED_PREFERENCES_DOMAIN, 0)
        var disclaimerAccepted = prefs.getBoolean(DISCLAIMER_KEY, false)
        if (!disclaimerAccepted) {
            val disclaimerIntent = Intent(this, DisclaimerActivity::class.java)
            startActivity(disclaimerIntent)
        }

        boulderingButton.setOnClickListener {
            startActivity("bouldering", prefs)
        }
        climbingButton.setOnClickListener {
            startActivity("climbing", prefs)
        }
    }

    private fun startActivity(selection: String, prefs: SharedPreferences) {
        val disclaimerAccepted = prefs.getBoolean(DISCLAIMER_KEY, false)
        if (disclaimerAccepted) {
            val climbingIntent = Intent(this, GradesActivity::class.java)
            climbingIntent.putExtra(EXTRA_CLIMBING_TYPE, selection)
            startActivity(climbingIntent)
        }
    }
}
