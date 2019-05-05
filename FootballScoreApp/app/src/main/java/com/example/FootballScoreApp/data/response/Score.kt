package com.example.FootballScoreApp.data.response


import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("duration")
    val duration: String,
    @SerializedName("extraTime")
    val extraTime: ExtraTime,
    @SerializedName("fullTime")
    val fullTime: FullTime,
    @SerializedName("halfTime")
    val halfTime: HalfTime,
    @SerializedName("penalties")
    val penalties: Penalties,
    @SerializedName("winner")
    val winner: Any
)
