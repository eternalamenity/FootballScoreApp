package com.example.FootballScoreApp.data

import com.example.FootballScoreApp.data.response.MatchDayResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "b77d4c5dfecd4a8a92481294da26fecc"

//https://api.football-data.org/v2/competitions/PL/matches?matchday=37

interface FootballDataApiService {

    @GET("competitions/PL/matches")
    fun getCurrentPremiereLeagueMatches(
        @Query("matchday") matchday: Int
    ): Deferred<MatchDayResponse>

    companion object {
        operator fun invoke(): FootballDataApiService {
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .header("X-Auth-Token", API_KEY)
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.football-data.org/v2/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FootballDataApiService::class.java)
        }
    }
}
