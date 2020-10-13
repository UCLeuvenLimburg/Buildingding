package buildingding.proximus.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.constraintlayout.widget.ConstraintLayout
import buildingding.proximus.R
import buildingding.proximus.model.Location
import buildingding.proximus.repository.LocationRepository

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initiateLocations()
        startMenuActivity()
    }

    private fun initiateLocations(): List<Location> {
        return LocationRepository
                .readLocationsFromCSV(application.assets.open("locations.csv"))
                .readConnectionsFromCSV(application.assets.open("neighbours.csv"))
                .locations.sortedBy { it.name }.toList()
    }

    private fun startMenuActivity() {
        val mRunnable = Runnable {
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }
        val mHandler = Handler()
        mHandler.postDelayed(mRunnable, 2000)
    }
}