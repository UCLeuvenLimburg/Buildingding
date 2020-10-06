package buildingding.proximus.model

import java.util.concurrent.atomic.AtomicInteger

class Location(val name: String, val floor: Floor, private val neighbours: List<Location> = emptyList()) {
    val id: Int
    var distance = Int.MAX_VALUE
    private var adjacentNodes: MutableMap<Location, Int> = HashMap()

    fun getAdjacentNodeDistance(node: Location): Int {
        return adjacentNodes[node]!!
    }

    fun addDestination(destination: Location, distance: Int) {
        adjacentNodes[destination] = distance
    }

    fun getAdjacentNodes(): Map<Location, Int> {
        return adjacentNodes
    }

    fun getNeighbour(name: String): Location? {
        return neighbours.find { neighbour -> neighbour.name === name }
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