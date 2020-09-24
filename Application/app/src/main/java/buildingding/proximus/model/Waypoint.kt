package buildingding.proximus.model

class Waypoint(name: String, neighbours: List<Location>, floor: Floor) :
    Location(name, neighbours, floor) {
}