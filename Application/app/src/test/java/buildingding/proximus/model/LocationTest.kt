package buildingding.proximus.model

import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class LocationTest {

    @Test
    fun testSameLocationIsEqual() {
        val locationC001 = location("C001", Floor.C0)
        Assert.assertEquals(locationC001, locationC001)
    }

    @Test
    fun testSameNameDifferentFloorIsNotEqual() {
        val locationFloorC0 = location("C001", Floor.C0)
        val locationFloorC1 = location("C001", Floor.C1)
        Assert.assertNotEquals(locationFloorC0, locationFloorC1)
    }

    @Test
    fun testSameFloorDifferentNameIsNotEqual() {
        val locationC001 = location("C001", Floor.C0)
        val locationC002 = location("C002", Floor.C0)
        Assert.assertEquals(locationC001, locationC002)
    }

    private fun location(name: String, floor: Floor): Location {
        return Location(name, floor)
    }
}