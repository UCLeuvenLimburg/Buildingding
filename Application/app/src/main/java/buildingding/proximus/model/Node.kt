package buildingding.proximus.model

class Node(name: String, neighbours: List<Location>, floor: Floor, location: Location) :
    Location(name, neighbours, floor) {
}