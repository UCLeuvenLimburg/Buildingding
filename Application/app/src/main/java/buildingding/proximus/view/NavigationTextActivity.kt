package buildingding.proximus.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import buildingding.proximus.R
import buildingding.proximus.model.Dijkstra
import buildingding.proximus.model.Graph
import buildingding.proximus.model.Location
import buildingding.proximus.repository.LocationRepository

class NavigationTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_text)
        val locationRepository = LocationRepository()
        initiateLocations(locationRepository)
        val linearLayoutLocations: LinearLayout = findViewById(R.id.scrollViewLayout)
        calculatePath(locationRepository, intent.getStringExtra("startPosition"), intent.getStringExtra("endPosition"))
                ?.forEach{
                    val textView = TextView(this)
                    textView.text = it
                    textView.textSize = 24f
                    textView.gravity = Gravity.CENTER
                    textView.setBackgroundColor(getColor(R.color.colorWhite))
                    textView.setTextColor(getColor(R.color.colorUcllDarkBlue))
                    textView.setPadding(0,24,0,24)
                    linearLayoutLocations.addView(textView)
                }
    }

    private fun calculatePath(locationRepository: LocationRepository, startLocation: String, endLocation: String): List<String?>? {
        val nodes = locationRepository.locations.associateBy({ it.id }, { it })
        val graph = Graph(nodes as HashMap<Int, Location>)
        // todo fix this bug
        val dijkstra = Dijkstra(graph.getPriorityQueue())
        /*
        println("\n All paths: \n")
        println(locationRepository.getLocationByName("C004")?.id?.let { dijkstra.calculatePaths(it, graph.nodes) })
        */
        val start = locationRepository.getLocationByName(startLocation)?.id
        val end = locationRepository.getLocationByName(endLocation)?.id
        return start?.let<Int, List<String?>?> { end?.let { it1 -> dijkstra.getPath(it, it1, nodes) } }
    }

    //todo make locationRepository global
    private fun initiateLocations(locationRepository: LocationRepository): List<Location> {
        return locationRepository
                .readLocationsFromCSV(application.assets.open("locations.csv"))
                .readConnectionsFromCSV(application.assets.open("neighbours.csv"))
                .locations.sortedBy { it.name }.toList()
    }
}