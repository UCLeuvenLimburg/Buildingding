package buildingding.proximus.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import buildingding.proximus.R
import buildingding.proximus.model.Location
import buildingding.proximus.repository.LocationRepository

class ChooseLocationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_locations)
        populateLocationList()
    }

    private fun populateLocationList(){
        val chosenStartLocation: String? = if (intent.hasExtra("startPosition"))  intent.getStringExtra("startPosition") else ""
        val chosenEndLocation: String? = if (intent.hasExtra("endPosition")) intent.getStringExtra("endPosition") else ""
        val target: String? = intent.getStringExtra("target")
        val linearLayoutLocations:LinearLayout = findViewById(R.id.scrollViewLayout)

        initiateLocations().forEach {
            val button = Button(this)
            val locationName = it.name
            button.text = locationName
            button.setOnClickListener {
                val intent = Intent(this@ChooseLocationsActivity, NavigationActivity::class.java)
                if (chosenStartLocation!!.isNotEmpty()) intent.putExtra("startPosition", chosenStartLocation)
                if (chosenEndLocation!!.isNotEmpty()) intent.putExtra("endPosition", chosenEndLocation)
                intent.putExtra(target, locationName)
                startActivity(intent)
            }
            linearLayoutLocations.addView(button)
        }
    }

    private fun initiateLocations(): List<Location> {
        return LocationRepository()
            .readLocationsFromCSV(application.assets.open("locations.csv"))
            .readConnectionsFromCSV(application.assets.open("neighbours.csv"))
            .locations.toList()
    }

}