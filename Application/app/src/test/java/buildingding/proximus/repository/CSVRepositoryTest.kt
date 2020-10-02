package buildingding.proximus.repository

import buildingding.proximus.model.Floor
import buildingding.proximus.model.Location
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CSVRepositoryTest {
    private val csvRepo = CSVRepository(ClassLoader.getSystemResourceAsStream("test_locations.csv"))
    private val c004_test = Location("c004",Floor.C0)

    @Test
    fun addLocationAddsCorrectLocation() {
        var locationCount = csvRepo.locations.size
        csvRepo.addLocation(c004_test)
        Assert.assertEquals(locationCount + 1, csvRepo.locations.size)
    }
}