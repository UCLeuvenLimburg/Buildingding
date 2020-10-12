package buildingding.proximus.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import buildingding.proximus.R
import buildingding.proximus.model.Location
import buildingding.proximus.repository.LocationRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiateContent()
        initiateLocations()
    }

    private fun initiateContent() {
        val constraintLayout:ConstraintLayout = findViewById(R.id.mainLayout)
        constraintLayout.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initiateLocations(): List<Location> {
        return LocationRepository
                .readLocationsFromCSV(application.assets.open("locations.csv"))
                .readConnectionsFromCSV(application.assets.open("neighbours.csv"))
                .locations.sortedBy { it.name }.toList()
    }
}