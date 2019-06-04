package com.example.FootballScoreApp.data.response


import com.google.gson.annotations.SerializedName

data class StandingsResponse(
    @SerializedName("competition")
    val competition: Competition,
    @SerializedName("filters")
    val filters: Filters,
    @SerializedName("season")
    val season: Season,
    @SerializedName("standings")
    val standings: List<Standing>
)
