package buildingding.proximus.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import buildingding.proximus.R
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val file_name = "locations.csv"
        val inputStream = application.assets.open(file_name)
        val rows = csvReader().readAll(inputStream)
        val spinner_start = findViewById<Spinner>(R.id.spinner_start)
        val spinner_end = findViewById<Spinner>(R.id.spinner_end)
        if (spinner_start != null && spinner_end != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, rows
            )
            spinner_start.adapter = adapter
            spinner_end.adapter = adapter
        }
    }

}