package com.example.FootballScoreApp.data.response


import com.google.gson.annotations.SerializedName

data class MatchDayResponse(
    @SerializedName("competition")
    val competition: Competition,
    @SerializedName("count")
    val count: Int,
    @SerializedName("filters")
    val filters: Filters,
    @SerializedName("matches")
    val matches: List<Match>
)
