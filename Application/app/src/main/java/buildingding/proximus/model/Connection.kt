package buildingding.proximus.model

open class Connection(name: String, neighbours: List<Location>, floor: Floor) :
    Location(name, neighbours, floor) {
}