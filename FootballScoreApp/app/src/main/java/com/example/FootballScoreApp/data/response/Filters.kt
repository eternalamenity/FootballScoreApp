package com.example.FootballScoreApp.data.response


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("matchday")
    val matchday: String
)
