package com.francislevesque.climbinggradeconverter.services

import com.francislevesque.climbinggradeconverter.models.GradingSystem

object DataService {
    val boulderSystems = listOf(
        GradingSystem("Font Scale", "france", "(Fontainebleau)"),
        GradingSystem("V Scale", "usa", "(Hueco)")
    )

    val climbingSystems = listOf(
        GradingSystem("YDS", "usa", "(Yosemite Decimal System)"),
        GradingSystem("British", "british"),
        GradingSystem("French", "france"),
        GradingSystem("UIAA", "eu"),
        GradingSystem("Saxon", "saxon"),
        GradingSystem("Ewbank", "australia", "(Australia and New Zealand)"),
        GradingSystem("Ewbank", "south_africa", "(South Africa)"),
        GradingSystem("Brazilian", "brazil"),
        GradingSystem("Kurtyka", "poland")
    )
}