package club.gitmad.spacexlaunches

import club.gitmad.spacexlaunches.models.Launches
import retrofit2.Call
import retrofit2.http.GET

/** Retrofit service for the SpaceX API. */
interface LaunchesService {
    @GET("/v4/launches/upcoming")
    fun getUpcomingLaunches(): Call<Launches>
}
