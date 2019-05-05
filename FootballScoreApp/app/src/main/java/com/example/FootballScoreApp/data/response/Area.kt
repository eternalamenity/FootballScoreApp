package com.example.FootballScoreApp.data.response


import com.google.gson.annotations.SerializedName

data class Area(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)
