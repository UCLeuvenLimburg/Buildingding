package buildingding.proximus.view

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import buildingding.proximus.R
import buildingding.proximus.model.RouteDisplay
import buildingding.proximus.repository.SettingsRepository

class ChooseRouteDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_locations)
        populateList()
    }

    private fun populateList() {
        val linearLayoutLocations: LinearLayout = findViewById(R.id.scrollViewLayout)
        enumValues<RouteDisplay>().forEach {
            val textView = TextView(this)
            val choice = it.name
            textView.text = choice
            textView.textSize = 24f
            textView.gravity = Gravity.CENTER
            textView.setBackgroundColor(getColor(R.color.colorWhite))
            textView.setTextColor(getColor(R.color.colorUcllDarkBlue))
            textView.setPadding(0, 24, 0, 24)
            textView.setOnClickListener {
                val intent = Intent(this@ChooseRouteDisplay, MenuActivity::class.java)
                SettingsRepository.routeDisplay = RouteDisplay.valueOf(choice)
                startActivity(intent)
            }
            linearLayoutLocations.addView(textView)
        }
    }
}