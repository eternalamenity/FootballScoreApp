package com.example.FootballScoreApp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.standing_row.view.*

class StandingsAdapter(
    val listOfTeams: MutableList<String>,
    val listOfMatchesPlayed: MutableList<String>,
    val listOfGoals: MutableList<String>,
    val listOfPoints: MutableList<String>,
    val listOfPositions: MutableList<String>,
    val context: Context
) : RecyclerView.Adapter<StandingsViewHolder>() {

    override fun getItemCount(): Int {
        return listOfTeams.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingsViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val cellForRow = layoutInflater.inflate(R.layout.standing_row, parent, false)
        return StandingsViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: StandingsViewHolder, position: Int) {
        val actualPosition = listOfPositions[position]
        val actualTeam = listOfTeams[position]
        val acualMatchesPlayed = listOfMatchesPlayed[position]
        val actualGoals = listOfGoals[position]
        val acutalPoints = listOfPoints[position]

        Log.d("MyApp",actualPosition)
        Log.d("MyApp",actualTeam)
        Log.d("MyApp",acualMatchesPlayed)
        Log.d("MyApp",actualGoals)
        Log.d("MyApp",acutalPoints)


        holder?.view?.position?.text = actualPosition
        holder?.view?.teamName?.text = actualTeam
        holder?.view?.playedGames?.text = acualMatchesPlayed
        holder?.view?.goals?.text = actualGoals
        holder?.view?.points?.text = acutalPoints
    }
}

class StandingsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}
