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

    fun fetchGradingSet(type: String) : List<GradingSystem> {
        return when (type) {
            "climbing" -> climbingSystems
            "bouldering" -> boulderSystems
            else -> climbingSystems
        }
    }

    val yds = arrayOf(
        "3–4",
        "5",
        "5.1",
        "5.2",
        "5.3",
        "5.4",
        "5.5",
        "5.6",
        "5.7",
        "5.8",
        "5.9",
        "5.10a",
        "5.10b",
        "5.10c",
        "5.10d",
        "5.11a",
        "5.11b",
        "5.11c",
        "5.11d",
        "5.12a",
        "5.12b",
        "5.12c",
        "5.12d",
        "5.13a",
        "5.13b",
        "5.13c",
        "5.13d",
        "5.14a",
        "5.14b",
        "5.14c",
        "5.14d",
        "5.15a",
        "5.15b",
        "5.15c",
        "5.15d"
    )

    val french = arrayOf(
        "1",
        "1/2",
        "2",
        "2/3",
        "3",
        "4a",
        "4b",
        "4c",
        "5a",
        "5b",
        "5c",
        "6a",
        "6a+",
        "6b",
        "6b+",
        "6b+/6c",
        "6c",
        "6c+",
        "6c+/7a",
        "7a",
        "7a+",
        "7b",
        "7b+",
        "7c",
        "7c+",
        "8a",
        "8a+",
        "8b",
        "8b+",
        "8c",
        "8c+",
        "9a",
        "9a+",
        "9b",
        "9b+",
        "9c"
    )
}