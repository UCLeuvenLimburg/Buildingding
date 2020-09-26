package buildingding.proximus.repository

import buildingding.proximus.model.*

class InMemoryRepository (
    var locations: MutableSet<Location> = mutableSetOf(
        Classroom("C101", emptyList(),Floor.C1),
        Classroom("C102", emptyList(),Floor.C1),
        Classroom("C103", emptyList(),Floor.C1),
        Classroom("C104", emptyList(),Floor.C1),
        Classroom("C105", emptyList(),Floor.C1),
        Classroom("C106", emptyList(),Floor.C1),
        Classroom("C107", emptyList(),Floor.C1),
        Classroom("C108", emptyList(),Floor.C1),
        Classroom("C109", emptyList(),Floor.C1),
        Classroom("C110", emptyList(),Floor.C1),
        Classroom("C111", emptyList(),Floor.C1),
        Toilet("C1WCM1", emptyList(), Floor.C1, ToiletType.MALE),
        Toilet("C1WCM2", emptyList(),Floor.C1, ToiletType.MALE),
        Toilet("C1WCM3", emptyList(),Floor.C1, ToiletType.MALE),
        Location("C111", emptyList(),Floor.C1)
    //todo complete this list!!!
    )
) {

    fun addLocation(location: Location): Boolean {
        return locations.add(location)
    }

    fun getAllLocations(): List<Location> {
        return locations.toList()
    }

    fun getLocationByName(name: String): Location? {
        return locations.find{ it.name.equals(name) }
    }

    fun getLocationsByFloor(floor: Floor): List<Location> {
        return locations.filter { it -> it.floor.equals(floor) }
    }

    fun getIndexOfLocationByName(name: String): Int {
        return locations.indexOf(getLocationByName(name))
    }

    fun updateLocation(location: Location): Boolean {
        if(locations.remove(getLocationByName(location.name))) {
            return locations.add(location)
        }
        return false
    }

    fun removeLocationByName(name: String) {
        locations.remove(getLocationByName(name))
    }
    fun removeAllLocations() {
        locations.clear()
    }
}