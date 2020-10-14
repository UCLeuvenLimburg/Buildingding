package buildingding.proximus.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import buildingding.proximus.R
import buildingding.proximus.model.Floor
import buildingding.proximus.model.Location
import buildingding.proximus.repository.LocationRepository

class WelcomeActivity : AppCompatActivity() {
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initiateLocations()
        startMenuActivity()
    }

    private fun initiateLocations(): List<Location> {
        val allowed = arrayOf(Floor.B0, Floor.C0, Floor.C1)
        return LocationRepository
                .readLocationsFromCSV(application.assets.open("locations.csv"))
                .readConnectionsFromCSV(application.assets.open("neighbours.csv"))
                .removeAllLocationsExceptFromFloors(allowed)
                .locations.sortedBy { it.name }.toList()

    }

    private fun startMenuActivity() {
        mRunnable = Runnable {
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }
        mHandler = Handler()
        mHandler.postDelayed(mRunnable, 2000)
    }

    override fun onStop() {
        super.onStop()
        mHandler.removeCallbacks(mRunnable)
    }
}