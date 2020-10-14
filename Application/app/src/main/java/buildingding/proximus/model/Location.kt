package buildingding.proximus.model

import java.util.concurrent.atomic.AtomicInteger

class Location(val name: String, val floor: Floor) {
    val id: Int
    var distance = Int.MAX_VALUE
    private var neighbours: MutableMap<Location, Int> = HashMap()

    fun getAdjacentNeighbourDistance(node: Location): Int {
        return neighbours[node]!!
    }

    fun addDestination(destination: Location, distance: Int) {
        neighbours[destination] = distance
    }

    fun getNeighbours(): Map<Location, Int> {
        return neighbours
    }

    override fun toString(): String {
        return name
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Location

        if (name != other.name) return false
        if (floor != other.floor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + floor.hashCode()
        return result
    }

    companion object {
        private val count: AtomicInteger = AtomicInteger(0)
    }

    init {
        id = count.incrementAndGet()
    }

}