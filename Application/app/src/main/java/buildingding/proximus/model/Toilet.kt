package buildingding.proximus.model

class Toilet(name: String, neighbours: List<Location>, floor: Floor, toiletType: ToiletType) :
    Utility(name, neighbours, floor) {
}