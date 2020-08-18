package com.francislevesque.climbinggradeconverter.services

import android.graphics.Color
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
        GradingSystem("Ewbank ", "south_africa", "(South Africa)"),
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

    val british = listOf<Grade>(
        Grade("1/M"), Grade(""), Grade("2"), Grade("D"),
        Grade("3"), Grade("VD"), Grade("4a/S"), Grade("4b/HS"),
        Grade("4c/VS"), Grade("HVS"), Grade("5a"), Grade("E1"),
        Grade("5b"), Grade("E2"), Grade("5c"), Grade("E3"),
        Grade(""), Grade("6a/E4"), Grade(""), Grade("E5"),
        Grade(""), Grade("6b/E6"), Grade(""), Grade("E7"),
        Grade("6c"), Grade("E8"), Grade("E9"), Grade("7a/E10"),
        Grade(""), Grade("7b/E11"), Grade(""), Grade(""),
        Grade(""), Grade(""), Grade("")
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

    val ewbank = listOf<Grade>(
        Grade("1–2"), Grade("3–4"), Grade("5–6"), Grade("7"),
        Grade("8–9"), Grade("10"), Grade("11–12"), Grade("13"),
        Grade("14–15"), Grade("16"), Grade("17"), Grade("18"),
        Grade("19"), Grade("20"), Grade(""), Grade("21"),
        Grade("22"), Grade("23"), Grade(""), Grade("24"),
        Grade("25"), Grade("26"), Grade("27"), Grade("28"),
        Grade("29"), Grade("30"), Grade("31"), Grade("32"),
        Grade("33"), Grade("34"), Grade("35"), Grade("36"),
        Grade("37"), Grade("38"), Grade("39")
    )

    val ewbank_sa = listOf<Grade>(
        Grade("1–2"), Grade("3–4"), Grade("5–6"), Grade("7"),
        Grade("8–9"), Grade("10"), Grade("11–12"), Grade("13"),
        Grade("14–15"), Grade("16"), Grade("17–18"), Grade("19"),
        Grade("20"), Grade("21"), Grade("22"), Grade(""),
        Grade("23"), Grade("24"), Grade("25"), Grade("26"),
        Grade("27"), Grade("28"), Grade("29"), Grade("30"),
        Grade("31"), Grade("32"), Grade("33"), Grade("34"),
        Grade("35"), Grade("36"), Grade("37"), Grade("38"),
        Grade("39"), Grade("40"), Grade("")
    )

    val brazilian = listOf<Grade>(
        Grade("I"), Grade("I sup"), Grade("II"), Grade("II sup"),
        Grade(""), Grade("III"), Grade("III sup"), Grade("IV"),
        Grade(""), Grade("IV sup"), Grade("V"), Grade("VI"),
        Grade(""), Grade("VI sup"), Grade(""), Grade("7a"),
        Grade("7b"), Grade("7c"), Grade(""), Grade("8a"),
        Grade("8b"), Grade("8c"), Grade("9a"), Grade("9b"),
        Grade("9c"), Grade("10a"), Grade("10b"), Grade("10c"),
        Grade("11a"), Grade("11b"), Grade("11c"), Grade("12a"),
        Grade("12b"), Grade("12c"), Grade("")
    )

    val kurtyka = listOf<Grade>(
        Grade("I"), Grade(""), Grade("II"), Grade(""),
        Grade("III"), Grade("IV"), Grade(""), Grade("IV+"),
        Grade("V-"), Grade("V"), Grade("V+"), Grade("VI"),
        Grade("VI+"), Grade("VI.1"), Grade("VI.1+"), Grade("VI.2VI.2+"),
        Grade(""), Grade(""), Grade("VI.3"), Grade("VI.3+"),
        Grade("VI.4"), Grade(""), Grade("VI.4+"), Grade("VI.5"),
        Grade("VI.5+"), Grade(""), Grade("VI.6"), Grade("VI.6+"),
        Grade("VI.7"), Grade("VI.7+"), Grade("VI.8"), Grade(""),
        Grade(""), Grade(""), Grade("")
    )

    fun fetchGrades(type: String?) : List<Grade> {
        return when (type) {
            "YDS" -> yds
            "British" -> british
            "French" -> french
            "UIAA" -> uiaa
            "Saxon" -> saxon
            "Ewbank" -> ewbank
            "Ewbank " -> ewbank_sa
            "Brazilian" -> brazilian
            "Kurtyka" -> kurtyka
            else -> yds
        }
    }
}