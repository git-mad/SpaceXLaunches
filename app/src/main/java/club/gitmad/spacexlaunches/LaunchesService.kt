package club.gitmad.spacexlaunches

import club.gitmad.spacexlaunches.models.Launches
import retrofit2.Call
import retrofit2.http.GET

/** Retrofit service for the SpaceX API. */
interface LaunchesService {
    // TODO: (2) Create a @GET method in the interface to get upcoming launches.
    // The API endpoint should look like /v4/______/_______
    // Find the API endpoint for upcoming launches here: https://github.com/r-spacex/SpaceX-API/blob/master/docs/v4/README.md
    // Call the method `getUpcomingLaunches`. It should return type `Call<Launches>`
}
