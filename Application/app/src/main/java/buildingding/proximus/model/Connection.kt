package buildingding.proximus.model

class Connection(name: String, neighbours: List<Location>, floor: Floor) :
Location(name, neighbours, floor) {
}