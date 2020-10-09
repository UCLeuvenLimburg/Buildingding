package buildingding.proximus.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import buildingding.proximus.R
import com.google.zxing.integration.android.IntentIntegrator

class NavigationActivity : AppCompatActivity() {
    lateinit var buttonStartPosition: Button
    var startPostieString: String = ""
    var eindPostieString: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        buttonStartPosition = findViewById(R.id.button_start_position)
        buttonStartPosition.setOnClickListener {
            val intentIntegrator = IntentIntegrator(this@NavigationActivity)
            intentIntegrator.setBeepEnabled(false)
            intentIntegrator.setCameraId(0)
            intentIntegrator.setPrompt("SCAN")
            intentIntegrator.setBarcodeImageEnabled(false)
            intentIntegrator.initiateScan()
        }
    }
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show()
            } else {
                startPostieString = String.format(result.contents)
                buttonStartPosition.text = startPostieString
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}