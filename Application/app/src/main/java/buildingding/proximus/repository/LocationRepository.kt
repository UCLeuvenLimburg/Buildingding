package buildingding.proximus.repository

import buildingding.proximus.model.Floor
import buildingding.proximus.model.Location
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.InputStream

object LocationRepository : Throwable() {
    val locations: MutableSet<Location> = mutableSetOf()

    fun readConnectionsFromCSV(inputStream: InputStream): LocationRepository {
        try {
            val list = csvReader().readAll(inputStream)
            list.forEach { row ->
                val neighbour =
                        locations.find { neighbour ->
                            neighbour.name == row[1]
                        }
                if (neighbour != null) {
                    locations.find { location ->
                        location.name == row[0]
                    }?.addDestination(neighbour, row[2].toInt())
                }
            }
            return this
        } catch (e: Exception) {
            throw  Exception("Couldn't read locations from inputstream")
        }
    }

    fun readLocationsFromCSV(inputStream: InputStream): LocationRepository {
        try {
            val list = csvReader().readAll(inputStream)
            list.forEach { row -> locations.add(Location(row[0], Floor.valueOf(row[1]))) }
            return this
        } catch (e: Exception) {
            throw  Exception("Couldn't read locations from inputstream")
        }
    }

    private fun addLocation(location: Location): Boolean {
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

    private fun removeLocationByName(name: String) {
        locations.remove(getLocationByName(name))
    }

    fun removeAllLocations() {
        locations.clear()
    }

    fun removeAllLocationsExceptFromFloors(floors: Array<Floor>): LocationRepository {
        locations.removeIf { !floors.contains(it.floor) }
        return this
    }

    fun getRealLocations(): MutableSet<Location> {
        locations.first().name.contains("X", false)
        return locations.filterNot {
            it.name.contains("X", false)
        }.toMutableSet()
    }

    fun getRealLocationsNames(): List<String> {
        return getRealLocations().map { it -> it.name }
    }
}