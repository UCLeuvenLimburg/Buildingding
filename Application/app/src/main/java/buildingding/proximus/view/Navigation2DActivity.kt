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
    var res : List<String>? = null
    var path: VectorDrawableCompat.VFullPath? = null
    var vb0: VectorChildFinder? = null
    var vc0: VectorChildFinder? = null
    var imgB0: ImageView? = null
    var imgC0: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation2_d)
        setTitle(R.string.title_2D_navigation)
        imgB0 = findViewById(R.id.image)
        imgC0 = findViewById(R.id.image1)
        vb0 = VectorChildFinder(this, R.drawable.ic_bb, imgB0)
        vc0 = VectorChildFinder(this, R.drawable.c0, imgC0)
        res = intent.getStringArrayListExtra("list")
        onButtonClick()

    }

    private fun onButtonClick() {
        var x = res?.size?.minus(1);
        for (i in 1 until x!!) {
            when (res!![i-1]?.substring(0, 2)) {
                "B0" -> {
                    var pathName = res!![i-1] + "_" + res!![i]
                    path = vb0?.findPathByName(pathName)
                    path?.setStrokeColor(Color.RED)
                    path?.setFillColor(Color.RED)
                }
                "C0" -> {

                    path = vc0?.findPathByName(res!![i])
                    path?.setStrokeColor(Color.RED)
                    path?.setFillColor(Color.RED)

                }
                else -> {
                }
            }
        }
        imgB0!!.invalidate()
        imgC0!!.invalidate()
    }

}