package com.example.FootballScoreApp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.match_row.view.*

class MainMatchesAdapter : RecyclerView.Adapter<MatchViewHolder>() {

    val listOfHosts = listOf("Liverpool", "Manchester City", "Liverpool", "Liverpool", "LIVERPOOL")
    val listOfGuests = listOf("Chealse FC", "Liverpool", "Manchester United", "Cardiff City", "CHAMPION")
    val listOfResults = listOf("1:0", "0:3", "5:0", "3:0", "IS A")

    override fun getItemCount(): Int {
        return listOfHosts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.match_row, parent, false)
        return MatchViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val actualHost = listOfHosts.get(position)
        val acualGuests = listOfGuests.get(position)
        val actualResults = listOfResults.get(position)
        holder?.view?.hostTeam?.text = actualHost
        holder?.view?.guestTeam?.text = acualGuests
        holder?.view?.matchResult?.text = actualResults
    }
}

class MatchViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}