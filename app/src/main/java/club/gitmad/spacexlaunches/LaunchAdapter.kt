package club.gitmad.spacexlaunches

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import club.gitmad.spacexlaunches.models.Launch
import club.gitmad.spacexlaunches.models.Launches
import com.squareup.picasso.Picasso

/** RecyclerView adapter for launch cards. */
class LaunchAdapter(private val launches: Launches) :
    RecyclerView.Adapter<LaunchAdapter.LaunchViewHolder>() {

    // Provide a reference to the views for each data item
    class LaunchViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var launchName: TextView? = null;
        private var launchDetails: TextView? = null;
        private var launchDate: TextView? = null;
        private var patchImg: ImageView? = null;

        init {
            launchName = v.findViewById(R.id.name)
            launchDetails = v.findViewById(R.id.details)
            launchDate = v.findViewById(R.id.date)
            patchImg = v.findViewById(R.id.patch)
        }

        // Bind `Launch` object data to the current card items.
        fun bind(launch: Launch) {
            launchName?.text = launch.name
            launchDetails?.text = launch.details
            launchDate?.text = launch.date_local
            Picasso.get().load(launch.links.patch.small).into(patchImg);
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LaunchViewHolder {
        // create a new view
        val launchCard = LayoutInflater.from(parent.context)
            .inflate(R.layout.launch_card, parent, false)
        return LaunchViewHolder(launchCard)
    }

    // Replace the contents of the view
    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        // - get launch from the dataset at this position
        // - replace the contents of the view with that element
        holder.bind(launches[position])
    }

    // Return the size the dataset.
    override fun getItemCount() = launches.size
}
