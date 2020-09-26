package buildingding.proximus.model

class Elevator(name: String, neighbours: List<Location>, floor: Floor, direction: Direction) : Connection(name,neighbours, floor,direction) {
}