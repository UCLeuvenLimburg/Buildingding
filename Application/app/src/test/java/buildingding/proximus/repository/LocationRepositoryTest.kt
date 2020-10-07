package buildingding.proximus.repository

import buildingding.proximus.model.Floor
import buildingding.proximus.model.Location
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class LocationRepositoryTest {
    private val csvRepo = LocationRepository()
    private val c004Test = Location("c004",Floor.C0)
    private val c001 = Location("c001",Floor.C0)
    private val c002 = Location("c002",Floor.C0)
    private val c003 = Location("c003",Floor.C0)
    private val c103Erranous = Location("c103",Floor.C2)
    private val c103Corrected = Location("c103",Floor.C1)
    private val listOfLocationsOnFloorC0 = listOf(c001,c002,c003)
    private val emptyList = emptyList<Location>()
    private val listOfAllLocations = listOf(c001,c002,c003,c103Erranous)
    private val listOfAllLocationsWithC103Removed = listOf(c001,c002,c003)
    private val nameOfLocation = "c103"

    @Before
    fun addLocations() {
        csvRepo.readLocationsFromCSV(ClassLoader.getSystemResourceAsStream("test_locations.csv"))
    }

    @Test
    fun addLocationAddsCorrectLocation() {
        val locationCount = csvRepo.locations.size
        csvRepo.addLocation(c004Test)
        Assert.assertEquals(locationCount + 1, csvRepo.locations.size)
    }

    @Test
    fun addLocationWhichWasAlreadyPresentDoesNotGetAdded() {
        csvRepo.addLocation(c004Test)
        val locationCount = csvRepo.locations.size
        csvRepo.addLocation(c004Test)
        Assert.assertEquals(locationCount, csvRepo.locations.size)
    }

    @Test
    fun getLocationByCorrectNameReturnsExpectedLocation() {
        csvRepo.addLocation(c004Test)
        val actual = csvRepo.getLocationByName(c004Test.name)
        Assert.assertEquals(c004Test,actual)
    }

    @Test
    fun getLocationByIncorrectNameReturnsNull() {
        Assert.assertNull(csvRepo.getLocationByName(c004Test.name))
    }

    @Test
    fun getLocationsByCorrectFloorReturnsCorrectList() {
        Assert.assertEquals(listOfLocationsOnFloorC0, csvRepo.getLocationsByFloor(Floor.C0))
    }

    @Test
    fun getLocationsByEmptyFloorReturnsEmptyList() {
        Assert.assertEquals(emptyList, csvRepo.getLocationsByFloor(Floor.C1))
    }

    @Test
    fun getAllLocationsAsList() {
        Assert.assertEquals(listOfAllLocations, csvRepo.locations.toList())
    }

    @Test
    fun updateLocation() {
        Assert.assertEquals(c103Corrected, csvRepo.updateLocation(c103Corrected))
        Assert.assertEquals(c103Corrected,csvRepo.getLocationByName(nameOfLocation))
    }

    @Test
    fun removeLocationByName() {
        csvRepo.removeLocationByName(nameOfLocation)
        Assert.assertEquals(listOfAllLocationsWithC103Removed,csvRepo.locations.toList())
    }

    @Test
    fun removeAllLocations() {
        csvRepo.removeAllLocations()
        Assert.assertEquals(emptyList,csvRepo.locations.toList())
    }


}