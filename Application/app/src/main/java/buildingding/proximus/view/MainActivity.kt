package buildingding.proximus.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import buildingding.proximus.R
import buildingding.proximus.model.Floor
import buildingding.proximus.model.Location
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rows = getLocationsAsFromCSVFile("locations.csv")
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
    }

    private fun getLocationsAsFromCSVFile(file: String): List<Location> {
        val inputStream = application.assets.open(file)
        val list = csvReader().readAll(inputStream)
        val locationMutableList = mutableListOf<Location>()
        list.forEach { row -> locationMutableList.add(Location(row[0], Floor.valueOf(row[1]))) }
        return  locationMutableList.toList()
    }
}