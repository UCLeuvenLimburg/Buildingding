package buildingding.proximus.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import buildingding.proximus.R
import buildingding.proximus.model.Dijkstra
import buildingding.proximus.model.Graph
import buildingding.proximus.model.Location
import buildingding.proximus.repository.LocationRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val locationRepository = LocationRepository()
        locationRepository.readLocationsFromCSV(application.assets.open("test_locations.csv"))
        locationRepository.readConnectionsFromCSV(application.assets.open("neighbours.csv"))
        val rows = locationRepository.locations.toList()
        val spinnerStart = findViewById<Spinner>(R.id.spinner_start)
        val spinnerEnd = findViewById<Spinner>(R.id.spinner_end)
        if (spinnerStart != null && spinnerEnd != null) {
            val adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item, rows
            )
            spinnerStart.adapter = adapter
            spinnerEnd.adapter = adapter
        }
        val nodes = locationRepository.locations.toList().associateBy({ it.id }, { it })
        val graph = Graph(nodes as HashMap<Int, Location>)
        val dijkstra = Dijkstra(graph.getPriorityQueue())
        /*
        println("\n All paths: \n")
        println(locationRepository.getLocationByName("C004")?.id?.let { dijkstra.calculatePaths(it, graph.nodes) })
         */
        val start = locationRepository.getLocationByName("C001")?.id
        val end = locationRepository.getLocationByName("C004")?.id
        val path = start?.let { end?.let { it1 -> dijkstra.getPath(it, it1, nodes) } }
    }
}