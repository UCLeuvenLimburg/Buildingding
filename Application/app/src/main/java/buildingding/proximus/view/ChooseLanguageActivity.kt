package buildingding.proximus.view

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import buildingding.proximus.R
import buildingding.proximus.model.Language
import buildingding.proximus.repository.SettingsRepository
import buildingding.proximus.repository.TextDirections
import java.util.*

class ChooseLanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_language)
        setTitle(R.string.settings_option_language)
        populateLanguages()
    }

    private fun populateLanguages() {
        val linearLayoutLocations: LinearLayout = findViewById(R.id.scrollViewLayout)
        enumValues<Language>().forEach {
            val textView = TextView(this)
            val choice = it.name
            textView.text = choice
            textView.textSize = 24f
            textView.gravity = Gravity.CENTER
            textView.setBackgroundColor(getColor(R.color.colorWhite))
            textView.setTextColor(getColor(R.color.colorUcllDarkBlue))
            textView.setPadding(0, 24, 0, 24)
            textView.setOnClickListener {
                val intent = Intent(this@ChooseLanguageActivity, MenuActivity::class.java)
                val config = resources.configuration
                val locale = Locale(choice.decapitalize(Locale.ROOT))
                Locale.setDefault(locale)
                config.locale = locale
                resources.updateConfiguration(config, resources.displayMetrics)
                SettingsRepository.language = Language.valueOf(choice)
                initiateDirections()
                startActivity(intent)
                finish()
            }
            linearLayoutLocations.addView(textView)
        }
    }

    private fun initiateDirections() {
        val directions = listOf<String>(getString(R.string.direction_first), getString(R.string.direction_second), getString(R.string.direction_third),getString(R.string.direction_fourth))
        TextDirections.sentences.clear()
        TextDirections.sentences.addAll(directions)
    }
}