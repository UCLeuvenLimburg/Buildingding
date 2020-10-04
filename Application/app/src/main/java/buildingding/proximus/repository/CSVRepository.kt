package buildingding.proximus.repository

import buildingding.proximus.model.Floor
import buildingding.proximus.model.Location
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.InputStream

class CSVRepository(val ips: InputStream) : Throwable() {
    var locations: MutableSet<Location> = mutableSetOf()

    init {
        try {
            //val inputStream = context.assets.open("locations.csv")
            val list = csvReader().readAll(ips)
            list.forEach { row -> locations.add(Location(row.get(0), Floor.valueOf(row.get(1)))) }
        } catch (e:Exception){
            throw  Exception("Couldn't read locations from inputstream")
        }
    }

    fun addLocation(location: Location): Boolean {
        return locations.add(location)
    }
    fun getLocationByName(name: String): Location? {
        return locations.find { it.name.equals(name) }
    }
    fun getLocationsByFloor(floor: Floor) : List<Location> {
        return locations.filter { it -> it.floor.equals(floor) }
    }
    fun getAllLocationsAsList() : List<Location> {
        return locations.toList()
    }
    fun updateLocation(location: Location): Location? {
        removeLocationByName(location.name)
        if (addLocation(location)) return location else return null
    }
    fun removeLocationByName(name: String) {
        locations.remove(getLocationByName(name))
    }
    fun removeAllLocations() {
        locations.clear()
    }
}