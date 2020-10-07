package buildingding.proximus.repository

import buildingding.proximus.model.Floor
import buildingding.proximus.model.Location
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.File
import java.io.InputStream

class LocationRepository() : Throwable() {
    val locations: MutableSet<Location> = mutableSetOf()

    fun readLocationsFromCSV(inputStream: InputStream) {
        try {
            val list = csvReader().readAll(inputStream)
            list.forEach { row -> locations.add(Location(row[0], Floor.valueOf(row[1]))) }
        } catch (e: Exception) {
            throw  Exception("Couldn't read locations from inputstream")
        }
    }

    fun addLocation(location: Location): Boolean {
        return locations.add(location)
    }

    fun getLocationByName(name: String): Location? {
        return locations.find { it.name == name }
    }

    fun getLocationsByFloor(floor: Floor): List<Location> {
        return locations.filter { it -> it.floor == floor }
    }

    fun updateLocation(location: Location): Location? {
        removeLocationByName(location.name)
        return if (addLocation(location)) location else null
    }

    fun removeLocationByName(name: String) {
        locations.remove(getLocationByName(name))
    }

    fun removeAllLocations() {
        locations.clear()
    }
}