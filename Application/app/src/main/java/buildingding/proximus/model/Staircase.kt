package buildingding.proximus.model

class Staircase(name: String, neighbours: List<Location>, floor: Floor) : Connection(name,neighbours, floor) {
}