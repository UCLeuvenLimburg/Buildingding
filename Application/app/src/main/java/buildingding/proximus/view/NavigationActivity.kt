package buildingding.proximus.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import buildingding.proximus.R
import buildingding.proximus.model.RouteDisplay
import buildingding.proximus.model.StartChoice
import buildingding.proximus.repository.SettingsRepository
import com.google.zxing.integration.android.IntentIntegrator

class NavigationActivity : AppCompatActivity() {
    private lateinit var buttonStartPosition: Button
    private lateinit var buttonEndPosition: Button
    private lateinit var buttonStartNavigation: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        setTitle(R.string.title_settings)

        buttonStartPosition = findViewById(R.id.button_start_position)
        if (SettingsRepository.startChoice == StartChoice.Scan) {
            buttonStartPosition.setOnClickListener {
                val intentIntegrator = IntentIntegrator(this@NavigationActivity)
                intentIntegrator.setBeepEnabled(false)
                intentIntegrator.setCameraId(0)
                intentIntegrator.setPrompt("SCAN")
                intentIntegrator.setBarcodeImageEnabled(false)
                intentIntegrator.initiateScan()
            }
        } else {
            buttonStartPosition.setOnClickListener {
                val intent = Intent(this@NavigationActivity, ChooseLocationsActivity::class.java)
                intent.putExtra("endPosition", buttonEndPosition.text)
                intent.putExtra("target", "startPosition")
                startActivity(intent)
            }
        }

        buttonEndPosition = findViewById(R.id.button_end_position)
        buttonEndPosition.setOnClickListener {
            val intent = Intent(this@NavigationActivity, ChooseLocationsActivity::class.java)
            intent.putExtra("startPosition", buttonStartPosition.text)
            intent.putExtra("target", "endPosition")
            startActivity(intent)
        }

        buttonStartNavigation = findViewById(R.id.button_start_navigation)
        buttonStartNavigation.setOnClickListener {
            val intent = if (SettingsRepository.routeDisplay == RouteDisplay.Text) {
                Intent(this@NavigationActivity, NavigationTextActivity::class.java)
            } else {
                Intent(this@NavigationActivity, Navigation2DActivity::class.java)
            }
            intent.putExtra("startPosition", buttonStartPosition.text)
            intent.putExtra("endPosition", buttonEndPosition.text)
            startActivity(intent)
        }

        if (intent.hasExtra("startPosition")) buttonStartPosition.text =
                intent.getStringExtra("startPosition")
        if (intent.hasExtra("endPosition")) buttonEndPosition.text =
                intent.getStringExtra("endPosition")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show()
            } else {
                buttonStartPosition.text = String.format(result.contents)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}