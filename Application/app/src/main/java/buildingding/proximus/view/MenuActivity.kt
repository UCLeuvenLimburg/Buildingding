package buildingding.proximus.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import buildingding.proximus.R

class MenuActivity : AppCompatActivity() {
    private lateinit var buttonNavigation: Button
    private lateinit var buttonSettings: Button
    private lateinit var buttonAbout: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        buttonNavigation = findViewById(R.id.button_navigation)
        buttonNavigation.setOnClickListener {
            val intent = Intent(this@MenuActivity, NavigationActivity::class.java)
            startActivity(intent)
        }
        buttonSettings = findViewById(R.id.button_settings)
        buttonSettings.setOnClickListener {
            val intent = Intent(this@MenuActivity, SettingsActivity::class.java)
            startActivity(intent)
        }
        buttonAbout = findViewById(R.id.button_about)
        buttonAbout.setOnClickListener {
            val intent = Intent(this@MenuActivity, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}