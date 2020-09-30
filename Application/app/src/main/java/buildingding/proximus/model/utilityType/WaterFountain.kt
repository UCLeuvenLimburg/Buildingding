package buildingding.proximus.model.utilityType

import buildingding.proximus.model.Floor
import buildingding.proximus.model.Location
import buildingding.proximus.model.Utility

class WaterFountain(name: String, neighbours: List<Location>, floor: Floor) :
    Utility(name, neighbours, floor) {
}