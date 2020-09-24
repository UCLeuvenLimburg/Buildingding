package buildingding.proximus.model

open class Location(val name: String, val neighbours: List<Location>, val floor: Floor) {
}