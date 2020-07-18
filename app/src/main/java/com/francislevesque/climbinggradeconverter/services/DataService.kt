package com.francislevesque.climbinggradeconverter.services

import com.francislevesque.climbinggradeconverter.models.Grade
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

    val yds = listOf<Grade>(
        Grade("3–4"), Grade("5"), Grade("5.1"), Grade("5.2"),
        Grade("5.3"), Grade("5.4"), Grade("5.5"), Grade("5.6"),
        Grade("5.7"), Grade("5.8"), Grade("5.9"), Grade("5.10a"),
        Grade("5.10b"), Grade("5.10c"), Grade("5.10d"), Grade("5.11a"),
        Grade("5.11b"), Grade("5.11c"), Grade("5.11d"), Grade("5.12a"),
        Grade("5.12b"), Grade("5.12c"), Grade("5.12d"), Grade("5.13a"),
        Grade("5.13b"), Grade("5.13c"), Grade("5.13d"), Grade("5.14a"),
        Grade("5.14b"), Grade("5.14c"), Grade("5.14d"), Grade("5.15a"),
        Grade("5.15b"), Grade("5.15c"), Grade("5.15d")
    )

    val french = listOf<Grade>(
        Grade("1"), Grade(""), Grade("2"), Grade(""),
        Grade("3"), Grade("4a"), Grade("4b"), Grade("4c"),
        Grade("5a"), Grade("5b"), Grade("5c"), Grade("6a"),
        Grade("6a+"), Grade("6b"), Grade("6b+"), Grade(""),
        Grade("6c"), Grade("6c+"), Grade("7a"), Grade("7a+"),
        Grade("7b"), Grade("7b+"), Grade("7c"), Grade("7c+"),
        Grade("8a"), Grade("8a+"), Grade("8b"), Grade("8b+"),
        Grade("8c"), Grade("8c+"), Grade("9a"), Grade("9a+"),
        Grade("9b"), Grade("9b+"), Grade("9c")
    )

    val uiaa = listOf<Grade>(
        Grade("I"), Grade(""), Grade("II"), Grade(""),
        Grade("III"), Grade("IV"), Grade("IV+/V-"), Grade("V"),
        Grade("V+"), Grade("VI-"), Grade("VI"), Grade("VI+"),
        Grade("VII-"), Grade("VII"), Grade("VII+"), Grade(""),
        Grade("VIII-"), Grade(""), Grade("VIII"), Grade("VIII+"),
        Grade(""), Grade("IX-"), Grade("IX"), Grade("IX+"),
        Grade(""), Grade("X-"), Grade("X"), Grade("X+"),
        Grade(""), Grade("XI-"), Grade("XI"), Grade("XI+"),
        Grade(""), Grade("XII-"), Grade("XII")
    )

    val saxon = listOf<Grade>(
        Grade("I"), Grade(""), Grade("II"), Grade(""),
        Grade("III"), Grade("IV"), Grade("V"), Grade("VI"),
        Grade(""), Grade("VIIa"), Grade("VIIb"), Grade("VIIc"),
        Grade(""), Grade("VIIIa"), Grade("VIIIb"), Grade("VIIIc"),
        Grade(""), Grade("IXa"), Grade("IXb"), Grade("IXc"),
        Grade(""), Grade("Xa"), Grade("Xb"), Grade("Xc"),
        Grade(""), Grade("XIa"), Grade("XIb"), Grade("XIc"),
        Grade(""), Grade("XIIa"), Grade(""), Grade(""),
        Grade(""), Grade(""), Grade("")
    )

    // TODO: Finish importing datasets

    fun fetchGrades(type: String?) : List<Grade> {
        return when (type) {
            "YDS" -> yds
            "French" -> french
            "UIAA" -> uiaa
            else -> yds
        }
    }
}