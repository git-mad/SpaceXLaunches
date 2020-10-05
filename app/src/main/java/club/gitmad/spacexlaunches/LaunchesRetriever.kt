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
    // TODO: (3) Set the Base URL for the API. The base URL is the part before /v4/____
    // Hint: it the url should end with a / after .com
    private val BASE_URL = ""

    init {
        // TODO: (4) Build the retrofit client and set the Base URL and the converter.
        val retrofit = Retrofit.Builder()
            .baseUrl(/** Set this to the BASE_URL variable. */)
            // Hint: We use the Gson library to convert JSON to Kotlin Objects.
            // Maybe look at the unused import and call .create() on it, i dunno I'm only a comment
            .addConverterFactory()
            .build()
        service = retrofit.create(LaunchesService::class.java)
    }

    fun getUpcomingLaunches(callback: Callback<Launches>) {
        // TODO: (5) Assign call to the return of `getUpcomingLaunches` in LaunchesService.
        // Hint: look at line 12.
        val call = null

        // Since requests are async, add the callback to a queue.
        call.enqueue(callback)
    }
}
