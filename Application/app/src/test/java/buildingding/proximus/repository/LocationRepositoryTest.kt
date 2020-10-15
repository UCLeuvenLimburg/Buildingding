package buildingding.proximus.repository

import buildingding.proximus.model.Floor
import buildingding.proximus.model.Location
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class LocationRepositoryTest {

    @Before
    fun addLocations() {
        LocationRepository.readLocationsFromCSV(ClassLoader.getSystemResourceAsStream("test_locations.csv"))
    }

    @Test
    fun addLocationAddsCorrectLocation() {
        val locationCount = LocationRepository.locations.size
        val locationC004 = location("c004", Floor.C0)
        LocationRepository.locations.add(locationC004)
        Assert.assertEquals(locationCount + 1, LocationRepository.locations.size)
        Assert.assertTrue(LocationRepository.locations.contains(locationC004))
    }

    @Test
    fun addLocationWhichWasAlreadyPresentDoesNotGetAdded() {
        val locationC004 = location("c004", Floor.C0)
        Assert.assertTrue(LocationRepository.locations.add(locationC004))
        val locationCount = LocationRepository.locations.size
        Assert.assertFalse(LocationRepository.locations.add(locationC004))
        Assert.assertEquals(locationCount, LocationRepository.locations.size)
    }

    @Test
    fun getLocationByCorrectNameReturnsExpectedLocation() {
        val locationC004 = location("c004", Floor.C0)
        LocationRepository.locations.add(locationC004)
        val actual = LocationRepository.getLocationByName(locationC004.name)
        Assert.assertEquals(locationC004, actual)
    }

    @Test
    fun getLocationByIncorrectNameReturnsNull() {
        val locationC004 = location("c004", Floor.C0)
        Assert.assertNull( LocationRepository.getLocationByName(locationC004.name))
    }

    @Test
    fun getLocationsByCorrectFloorReturnsCorrectList() {
        val c001 = location("c001", Floor.C0)
        val c002 = location("c002", Floor.C0)
        val c003 = location("c003", Floor.C0)
        val listOfLocationsOnFloorC0 = listOf(c001, c002, c003)
        Assert.assertEquals(listOfLocationsOnFloorC0, LocationRepository.getLocationsByFloor(Floor.C0))
    }

    @Test
    fun getLocationsByEmptyFloorReturnsEmptyList() {
        val emptyList = emptyList<Location>()
        Assert.assertEquals(emptyList, LocationRepository.getLocationsByFloor(Floor.C1))
    }

    @Test
    fun getAllLocationsAsList() {
        val c001 = location("c001", Floor.C0)
        val c002 = location("c002", Floor.C0)
        val c003 = location("c003", Floor.C0)
        val c103Erranous = location("c103", Floor.C2)
        val listOfAllLocations = listOf(c001, c002, c003, c103Erranous)
        Assert.assertEquals(listOfAllLocations, LocationRepository.locations.toList())
    }

    @Test
    fun updateLocation() {
        val locationC103 = location("c103", Floor.C1)
        val nameOfLocation = "c103"
        Assert.assertEquals(locationC103, LocationRepository.updateLocation(locationC103))
        Assert.assertEquals(locationC103, LocationRepository.getLocationByName(nameOfLocation))
    }

    @Test
    fun removeLocationByName() {
        val nameOfLocation = "c103"
        val locationC103 = location("c103", Floor.C1)
        val c001 = Location("c001", Floor.C0)
        val c002 = Location("c002", Floor.C0)
        val c003 = Location("c003", Floor.C0)
        val listOfAllLocationsWithC103Removed = listOf(c001, c002, c003)
        LocationRepository.locations.add(locationC103)
        Assert.assertTrue(LocationRepository.locations.remove(nameOfLocation))
        Assert.assertEquals(listOfAllLocationsWithC103Removed, LocationRepository.locations.toList())
    }

    @Test
    fun removeAllLocations() {
        val emptyList = emptyList<Location>()
        LocationRepository.removeAllLocations()
        Assert.assertEquals(emptyList, LocationRepository.locations.toList())
    }

    private fun location(name: String, floor: Floor): Location {
        return Location(name, floor)
    }
}