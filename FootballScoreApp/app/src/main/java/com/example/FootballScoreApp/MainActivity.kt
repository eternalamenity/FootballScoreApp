package com.example.FootballScoreApp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.FootballScoreApp.data.FootballDataApiService
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, "ca-app-pub-9929957078189954~5526922297")

        rViewMainMatches.layoutManager = LinearLayoutManager(this)
        rViewMainMatches.adapter = MainMatchesAdapter()

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val apiService = FootballDataApiService()
        GlobalScope.launch (Dispatchers.Main){
            val currentMatchDayResponse =  apiService.getCurrentPremiereLeagueMatches(37).await()
            textView.text = currentMatchDayResponse.matches.toString()
        }
    }
}
