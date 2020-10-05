package club.gitmad.spacexlaunches

import club.gitmad.spacexlaunches.models.Launches
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Builds a Retrofit instance based on `LaunchesService` and exposes a method to make an API call.
 */
class LaunchesRetriever {
    private val service: LaunchesService
    private val BASE_URL = "https://api.spacexdata.com/"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(LaunchesService::class.java)
    }

    fun getUpcomingLaunches(callback: Callback<Launches>) {
        val call = service.getUpcomingLaunches()
        call.enqueue(callback)
    }
}
