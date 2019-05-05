package com.example.FootballScoreApp.data.response


import com.google.gson.annotations.SerializedName

data class HalfTime(
    @SerializedName("awayTeam")
    val awayTeam: Any,
    @SerializedName("homeTeam")
    val homeTeam: Any
)
