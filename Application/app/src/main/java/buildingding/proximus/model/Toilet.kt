package buildingding.proximus.model

class Toilet(name: String, neighbours: List<Location>, floor: Floor, target: Target) :
    Utility(name, neighbours, floor) {
}