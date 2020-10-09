package buildingding.proximus.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import buildingding.proximus.R

class MenuActivity : AppCompatActivity() {
    lateinit var btnNavigation: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        btnNavigation = findViewById(R.id.button_navigation)
        btnNavigation.setOnClickListener {
            val intent = Intent(this@MenuActivity, NavigationActivity::class.java)
            startActivity(intent)
        }
    }
}