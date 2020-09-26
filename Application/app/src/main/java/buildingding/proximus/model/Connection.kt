package buildingding.proximus.model

open class Connection(name: String, neighbours: List<Location>, floor: Floor, direction: Direction) :
    Location(name, neighbours, floor) {
}