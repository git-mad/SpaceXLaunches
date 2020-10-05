package club.gitmad.spacexlaunches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import club.gitmad.spacexlaunches.models.Launches
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val launchesRetriever = LaunchesRetriever()

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the upcoming launches data from the API.
        launchesRetriever.getUpcomingLaunches(callback)
    }

    /** Callback for when the HTTP request has completed and return a value (or error). */
    private val callback = object : Callback<Launches> {
        override fun onFailure(call: Call<Launches>?, t:Throwable?) {
            Log.e("MainActivity", "Problem calling the SpaceX API {${t?.message}}")
        }

        override fun onResponse(call: Call<Launches>, response: Response<Launches>) {
            response.isSuccessful.let {
                val result = response.body()
                if (result != null) displayLaunches(result)
            }
        }
    }

    /** Displays all launches in the RecyclerView upon data loading from the API. */
    private fun displayLaunches(launches: Launches) {

        viewManager = LinearLayoutManager(this)
        viewAdapter = LaunchAdapter(launches)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify a viewAdapter
            adapter = viewAdapter

        }
    }
}
