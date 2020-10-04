package buildingding.proximus.model

import org.junit.Assert
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class LocationTest {
    private val c001Name = "c001"
    private val c001 = Location(c001Name,Floor.C0)
    private val c002Name = "c001"
    private val c001_otherFloor = Location(c001Name,Floor.C1)
    private val c002 = Location(c002Name,Floor.C0)


    @Test
    fun testToString() {
        Assert.assertEquals(c001Name,c001.toString())
    }

    @Test
    fun testSameLocationIsEqual() {
        Assert.assertEquals(c001,c001)
    }

    @Test
    fun testSameNameDifferentFloorIsNotEqual() {
        Assert.assertNotEquals(c001,c001_otherFloor)
    }

    @Test
    fun testSameFloorDifferentNameIsNotEqual() {
        Assert.assertEquals(c001,c002)
    }

}