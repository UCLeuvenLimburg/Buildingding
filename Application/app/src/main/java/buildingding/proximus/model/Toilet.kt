package buildingding.proximus.model

class Toilet(name: String, neighbours: List<Location>, floor: Floor, toiletType: ToiletType) :
    Location(name, neighbours, floor) {
}