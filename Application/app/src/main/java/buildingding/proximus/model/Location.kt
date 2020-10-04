package buildingding.proximus.model

// voorlopig met lege lijst van neighbours
class Location(val name: String, val floor: Floor, val neighbours: List<Location> = emptyList()) {
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

}