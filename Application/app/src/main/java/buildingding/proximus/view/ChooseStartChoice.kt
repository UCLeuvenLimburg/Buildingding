package buildingding.proximus.view

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import buildingding.proximus.R
import buildingding.proximus.model.StartChoice

class ChooseStartChoice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_locations)
        populateStartChoices()
    }

    private fun populateStartChoices(){
        val linearLayoutLocations: LinearLayout = findViewById(R.id.scrollViewLayout)
        enumValues<StartChoice>().forEach {
            val textView = TextView(this)
            val choice = it.name
            textView.text = choice
            textView.textSize = 24f
            textView.gravity = Gravity.CENTER
            textView.setBackgroundColor(getColor(R.color.colorWhite))
            textView.setTextColor(getColor(R.color.colorUcllDarkBlue))
            textView.setPadding(0,24,0,24)
            textView.setOnClickListener {
                val intent = Intent(this@ChooseStartChoice, SettingsActivity::class.java)
                startActivity(intent)
            }
            linearLayoutLocations.addView(textView)
        }
    }


}