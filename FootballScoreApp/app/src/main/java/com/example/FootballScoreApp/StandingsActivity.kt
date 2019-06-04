package com.example.FootballScoreApp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.FootballScoreApp.data.FootballDataApiService
import kotlinx.android.synthetic.main.activity_standings.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class StandingsActivity : AppCompatActivity() {
    private val apiService = FootballDataApiService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listOfTeams = mutableListOf<String>()
        val listOfMatchesPlayed = mutableListOf<String>()
        val listOfGoals = mutableListOf<String>()
        val listOfPoints = mutableListOf<String>()
        val listOfPositions = mutableListOf<String>()
        GlobalScope.launch(Dispatchers.Main) {
            val leagueTable = apiService.getPremiereLeagueTable().await()
            val standings = leagueTable.standings[0]

            for (standing in standings.table) {
                listOfPositions.add(standing.position.toString())
                listOfTeams.add(standing.team.name)
                listOfMatchesPlayed.add(standing.playedGames.toString())
                val goalString = standing.goalsFor.toString() + ":" + standing.goalsAgainst.toString()
                listOfGoals.add(goalString)
                listOfPoints.add(standing.points.toString())
            }
            Log.d("MyApp",listOfPositions.toString())
            Log.d("MyApp",listOfTeams.toString())
            Log.d("MyApp",listOfGoals.toString())
            Log.d("MyApp",listOfMatchesPlayed.toString())
            Log.d("MyApp",listOfPoints.toString())

        }
        setContentView(R.layout.activity_standings)
        rViewStandings.layoutManager = LinearLayoutManager(this)
        rViewStandings.adapter = StandingsAdapter(listOfPositions, listOfTeams, listOfMatchesPlayed, listOfGoals,listOfPoints, this)
    }
}
