package buildingding.proximus.repository

import buildingding.proximus.model.Floor
import buildingding.proximus.model.Location
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CSVRepositoryTest {
    private val csvRepo = CSVRepository(ClassLoader.getSystemResourceAsStream("test_locations.csv"))
    private val c004_test = Location("c004",Floor.C0)
    private val c001 = Location("c001",Floor.C0)
    private val c002 = Location("c002",Floor.C0)
    private val c003 = Location("c003",Floor.C0)
    private val c103_erranous = Location("c103",Floor.C2)
    private val c103_corrected = Location("c103",Floor.C1)
    private val listOfLocationsOnFloorC0 = listOf(c001,c002,c003)
    private val emptyList = emptyList<Location>()
    private val listOfAllLocations = listOf(c001,c002,c003,c103_erranous)
    private val listOfAllLocationsWithC103Removed = listOf(c001,c002,c003)
    private val nameOfLocation = "c103"

    @Test
    fun addLocationAddsCorrectLocation() {
        var locationCount = csvRepo.locations.size
        csvRepo.addLocation(c004_test)
        Assert.assertEquals(locationCount + 1, csvRepo.locations.size)
    }

    @Test
    fun addLocationWhichWasAlreadyPresentDoenNotGetAdded() {
        csvRepo.addLocation(c004_test)
        var locationCount = csvRepo.locations.size
        csvRepo.addLocation(c004_test)
        Assert.assertEquals(locationCount, csvRepo.locations.size)
    }

    @Test
    fun getLocationByCorrectNameReturnsExpectedLocation() {
        csvRepo.addLocation(c004_test)
        val actual = csvRepo.getLocationByName(c004_test.name)
        Assert.assertEquals(c004_test,actual)
    }

    @Test
    fun getLocationByIncorrectNameReturnsNull() {
        Assert.assertNull(csvRepo.getLocationByName(c004_test.name))
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
        Assert.assertEquals(listOfAllLocations, csvRepo.getAllLocationsAsList())
    }

    @Test
    fun updateLocation() {
        Assert.assertEquals(c103_corrected, csvRepo.updateLocation(c103_corrected))
        Assert.assertEquals(c103_corrected,csvRepo.getLocationByName(nameOfLocation))
    }

    @Test
    fun removeLocationByName() {
        csvRepo.removeLocationByName(nameOfLocation)
        Assert.assertEquals(listOfAllLocationsWithC103Removed,csvRepo.getAllLocationsAsList())
    }

    @Test
    fun removeAllLocations() {
        csvRepo.removeAllLocations()
        Assert.assertEquals(emptyList,csvRepo.getAllLocationsAsList())
    }


}