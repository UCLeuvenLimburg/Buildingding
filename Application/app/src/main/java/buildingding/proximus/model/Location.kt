package buildingding.proximus.model

// voorlopig met lege lijst van neighbours
class Location(val name: String, val floor: Floor, val neighbours: List<Location> = emptyList()) {
    fun getNeighbour(name: String): Location? {
        return neighbours.find { neighbour -> neighbour.name === name }
    }

    override fun toString(): String {
        return name
    }
}