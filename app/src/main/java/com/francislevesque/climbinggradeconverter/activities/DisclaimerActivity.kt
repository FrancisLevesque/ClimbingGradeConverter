package com.francislevesque.climbinggradeconverter.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import androidx.core.graphics.ColorUtils
import com.francislevesque.climbinggradeconverter.R
import com.francislevesque.climbinggradeconverter.utilities.DISCLAIMER_KEY
import com.francislevesque.climbinggradeconverter.utilities.SHARED_PREFERENCES_DOMAIN
import kotlinx.android.synthetic.main.activity_disclaimer.*

class DisclaimerActivity : AppCompatActivity() {
    private val disclaimer = "WARNING: Climbing is dangerous.\n\nThis app is exclusively meant to be used to convert " +
            "foreign grading systems into one you might be familiar with, but is in no way meant to be used to assess " +
            "the safety of any activity the users of this app might undertake.\n\nUsers of this app are completely " +
            "responsible for their own safety. If you are inexperienced, have doubts, or concerns please do not " +
            "put yourself in situations beyond your ability and seek the advice and/or help of a professional."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disclaimer)
        disclaimerText.text = disclaimer

        val alpha = 100
        val alphaColor = ColorUtils.setAlphaComponent(Color.parseColor("#000000"), alpha)
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), Color.TRANSPARENT, alphaColor)
        colorAnimation.duration = 500 // milliseconds
        colorAnimation.addUpdateListener { animator ->
            appBackground.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()

        disclaimerBackground.alpha = 0f
        disclaimerBackground.animate().alpha(1f).setDuration(500).setInterpolator(
            DecelerateInterpolator()
        ).start()

        disclaimerButton.setOnClickListener {
            disclaimerAccepted(this)
        }
    }

    private fun disclaimerAccepted(context: Context) {
        val alpha = 100
        val alphaColor = ColorUtils.setAlphaComponent(Color.parseColor("#000000"), alpha)
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), alphaColor, Color.TRANSPARENT)
        colorAnimation.duration = 500 // milliseconds
        colorAnimation.addUpdateListener { animator ->
            appBackground.setBackgroundColor(animator.animatedValue as Int)
        }

        disclaimerBackground.animate().alpha(0f).setDuration(500).setInterpolator(
            DecelerateInterpolator()
        ).start()

        colorAnimation.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                val prefs = context.getSharedPreferences(SHARED_PREFERENCES_DOMAIN, 0)
                val prefsEditor = prefs.edit()
                prefsEditor.putBoolean(DISCLAIMER_KEY, true).apply()
                finish()
                overridePendingTransition(0, 0)
            }
        })
        colorAnimation.start()
    }
}