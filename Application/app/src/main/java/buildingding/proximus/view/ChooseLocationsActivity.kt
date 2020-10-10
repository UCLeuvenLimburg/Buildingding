package buildingding.proximus.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import buildingding.proximus.R
import buildingding.proximus.repository.LocationRepository

class ChooseLocationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_locations)
        val scrollView:LinearLayout = findViewById(R.id.scrollViewLayout)

        val locationRepository = LocationRepository()
        locationRepository.readLocationsFromCSV(application.assets.open("locations.csv"))
        locationRepository.readConnectionsFromCSV(application.assets.open("neighbours.csv"))
        val locations = locationRepository.locations.toList()
        var chosenStartLocation: String = ""

        if (intent.hasExtra("startPosition")) chosenStartLocation = intent.getStringExtra("startPosition")

        locations.forEach {
            val button = Button(this)
            var locationName = it.name
            button.text = locationName
            button.setOnClickListener {
                val intent = Intent(this@ChooseLocationsActivity, NavigationActivity::class.java)
                if (!chosenStartLocation.isEmpty()) intent.putExtra("startPosition", chosenStartLocation)
                intent.putExtra("endPosition", locationName)
                startActivity(intent)
            }
            scrollView.addView(button)
        }
    }
}