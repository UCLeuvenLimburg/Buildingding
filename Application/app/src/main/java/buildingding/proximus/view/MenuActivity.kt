package buildingding.proximus.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import buildingding.proximus.R

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        initiateMenuButtons()
    }

    private fun initiateMenuButtons() {
        val buttonNavigation: Button = findViewById(R.id.button_navigation)
        buttonNavigation.setOnClickListener {
            val intent = Intent(this@MenuActivity, NavigationActivity::class.java)
            startActivity(intent)
        }
        val buttonSettings: Button = findViewById(R.id.button_settings)
        buttonSettings.setOnClickListener {
            val intent = Intent(this@MenuActivity, SettingsActivity::class.java)
            startActivity(intent)
        }
        val buttonAbout: Button = findViewById(R.id.button_about)
        buttonAbout.setOnClickListener {
            val intent = Intent(this@MenuActivity, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}