package buildingding.proximus.view

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import buildingding.proximus.R
import buildingding.proximus.model.Dijkstra
import buildingding.proximus.model.Graph
import buildingding.proximus.model.Location
import buildingding.proximus.repository.LocationRepository
import com.devs.vectorchildfinder.VectorChildFinder
import com.devs.vectorchildfinder.VectorDrawableCompat

class Navigation2DActivity : AppCompatActivity() {
    private lateinit var imgB0: ImageView
    var res : List<String>? = null
    var path: VectorDrawableCompat.VFullPath? = null
    var vb0: VectorChildFinder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation2_d)
        setTitle(R.string.title_2D_navigation)
        imgB0 = findViewById(R.id.image)
        vb0 = VectorChildFinder(this, R.drawable.ic_bb, imgB0)

        res = intent.getStringArrayListExtra("list")
        onButtonClick()

    }

    private fun onButtonClick() {
        val x = res?.size?.minus(1)
        for (i in 1 until x!!) {
            when (res!![i-1].substring(0, 2)) {
                "B0" -> {
                    val pathName = res!![i-1] + "_" + res!![i]
                    path = vb0?.findPathByName(pathName)
                    path?.strokeColor = Color.RED
                    path?.fillColor = Color.RED
                }
                else -> {
                }
            }
        }
        imgB0.invalidate()
    }

}