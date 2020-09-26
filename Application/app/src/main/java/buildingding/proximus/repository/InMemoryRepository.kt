package buildingding.proximus.repository

import buildingding.proximus.model.*

class InMemoryRepository(

    var locations: MutableSet<Location> = mutableSetOf(
        // D0
        Classroom("D022", emptyList(), Floor.D0),
        Classroom("D023", emptyList(), Floor.D0),
        Classroom("D024", emptyList(), Floor.D0),
        Classroom("D026", emptyList(), Floor.D0),
        Classroom("D080", emptyList(), Floor.D0),
        Multipurpose("D0M1", emptyList(), Floor.D0),
        Multipurpose("D0M2", emptyList(), Floor.D0),
        Connection("D0S1", emptyList(), Floor.D0, Direction.UP),
        Connection("D0S2", emptyList(), Floor.D0, Direction.DOWN),
        Connection("D0S3", emptyList(), Floor.D0, Direction.DOWN),
        Connection("D0S4", emptyList(), Floor.D0, Direction.DOWN),
        Connection("D0S5", emptyList(), Floor.D0, Direction.DOWN),
        Connection("D0E1", emptyList(),Floor.D0, Direction.OMNIDIRECTIONAL_VERTICAL),
        Connection("D0E2", emptyList(),Floor.D0, Direction.OMNIDIRECTIONAL_VERTICAL),
        Connection("D0E3", emptyList(),Floor.D0, Direction.OMNIDIRECTIONAL_VERTICAL),
        Toilet("D0WCM1", emptyList(), Floor.D0, ToiletType.MALE),
        Toilet("D0WCM2", emptyList(), Floor.D0, ToiletType.MALE),
        Toilet("D0WCF1", emptyList(), Floor.D0, ToiletType.FEMALE),
        Toilet("D0WCF2", emptyList(), Floor.D0, ToiletType.FEMALE),
        // D1
        Classroom("D111", emptyList(), Floor.D1),
        Classroom("D112", emptyList(), Floor.D1),
        Classroom("D114", emptyList(), Floor.D1),
        Classroom("D115", emptyList(), Floor.D1),
        Classroom("D116", emptyList(), Floor.D1),
        Classroom("D118", emptyList(), Floor.D1),
        Classroom("D121", emptyList(), Floor.D1),
        Classroom("D122", emptyList(), Floor.D1),
        Classroom("D124", emptyList(), Floor.D1),
        Classroom("D125", emptyList(), Floor.D1),
        Classroom("D126", emptyList(), Floor.D1),
        Classroom("D127", emptyList(), Floor.D1),
        Classroom("D128", emptyList(), Floor.D1),
        Classroom("D140a", emptyList(), Floor.D1),
        Classroom("D140", emptyList(), Floor.D1),
        Classroom("D140b", emptyList(), Floor.D1),
        Classroom("D141", emptyList(), Floor.D1),
        Classroom("D142", emptyList(), Floor.D1),
        Classroom("D143", emptyList(), Floor.D1),
        Classroom("D144", emptyList(), Floor.D1),
        Classroom("D145", emptyList(), Floor.D1),
        Classroom("D146", emptyList(), Floor.D1),
        Classroom("D148", emptyList(), Floor.D1),
        Classroom("D149", emptyList(), Floor.D1),
        Classroom("D153", emptyList(), Floor.D1),
        Classroom("D154", emptyList(), Floor.D1),
        Classroom("D155", emptyList(), Floor.D1),
        Classroom("D156", emptyList(), Floor.D1),
        Classroom("D157", emptyList(), Floor.D1),
        Classroom("D158", emptyList(), Floor.D1),
        Classroom("D159", emptyList(), Floor.D1),
        Classroom("D160", emptyList(), Floor.D1),
        Classroom("D161", emptyList(), Floor.D1),
        Classroom("D180", emptyList(), Floor.D1),
        Multipurpose("D1M1", emptyList(), Floor.D1),
        Multipurpose("Lounge", emptyList(), Floor.D1),
        Multipurpose("Bar", emptyList(), Floor.D1),
        Multipurpose("Restaurant", emptyList(), Floor.D1),
        Connection("D1S1", emptyList(), Floor.D1, Direction.UP),
        Connection("D1S2", emptyList(), Floor.D1, Direction.DOWN),
        Connection("D1S3", emptyList(), Floor.D1, Direction.DOWN),
        Connection("D1S4", emptyList(), Floor.D1, Direction.DOWN),
        Connection("D1E1", emptyList(),Floor.D1, Direction.OMNIDIRECTIONAL_VERTICAL),
        Connection("D1E2", emptyList(),Floor.D1, Direction.OMNIDIRECTIONAL_VERTICAL),
        Connection("D1E3", emptyList(),Floor.D1, Direction.OMNIDIRECTIONAL_VERTICAL),
        Toilet("D1WCM1", emptyList(), Floor.D1, ToiletType.MALE),
        Toilet("D1WCM2", emptyList(), Floor.D1, ToiletType.MALE),
        Toilet("D1WCM3", emptyList(), Floor.D1, ToiletType.MALE),
        Toilet("D1WCM4", emptyList(), Floor.D1, ToiletType.MALE),
        Toilet("D1WCM5", emptyList(), Floor.D1, ToiletType.MALE),
        Toilet("D1WCF1", emptyList(), Floor.D1, ToiletType.FEMALE),
        Toilet("D1WCF2", emptyList(), Floor.D1, ToiletType.FEMALE),
        Toilet("D1WCF3", emptyList(), Floor.D1, ToiletType.FEMALE),
        Toilet("D1WCF4", emptyList(), Floor.D1, ToiletType.FEMALE),
        Toilet("D1WCF5", emptyList(), Floor.D1, ToiletType.FEMALE),
        //D2
        Multipurpose("D210", emptyList(), Floor.D2),
        Multipurpose("D220", emptyList(), Floor.D2),
        Multipurpose("D230", emptyList(), Floor.D2),
        Toilet("D2WCM1", emptyList(), Floor.D2, ToiletType.MALE),
        Toilet("D2WCM2", emptyList(), Floor.D2, ToiletType.MALE),
        Toilet("D2WCF1", emptyList(), Floor.D2, ToiletType.FEMALE),
        Toilet("D2WCF2", emptyList(), Floor.D2, ToiletType.FEMALE),
        Connection("D2S1", emptyList(), Floor.D2, Direction.UP),
        Connection("D2S2", emptyList(), Floor.D2, Direction.DOWN),
        Connection("D2S3", emptyList(), Floor.D2, Direction.DOWN),
        Connection("D2E1", emptyList(),Floor.D2, Direction.OMNIDIRECTIONAL_VERTICAL),
        Connection("D2E2", emptyList(),Floor.D2, Direction.OMNIDIRECTIONAL_VERTICAL),
        Connection("D2E3", emptyList(),Floor.D2, Direction.OMNIDIRECTIONAL_VERTICAL),
        // C0
        Classroom("C001", emptyList(), Floor.C0),
        Classroom("C002", emptyList(), Floor.C0),
        Classroom("C003", emptyList(), Floor.C0),
        Classroom("C004", emptyList(), Floor.C0),
        Classroom("C005", emptyList(), Floor.C0),
        Classroom("C006", emptyList(), Floor.C0),
        Classroom("C007", emptyList(), Floor.C0),
        Classroom("C008", emptyList(), Floor.C0),
        Classroom("C009", emptyList(), Floor.C0),
        Classroom("C010", emptyList(), Floor.C0),
        Classroom("C011", emptyList(), Floor.C0),
        Classroom("C015", emptyList(), Floor.C0),
        Classroom("C016", emptyList(), Floor.C0),
        Toilet("C0WCM1", emptyList(), Floor.C0, ToiletType.MALE),
        Toilet("C0WCM2", emptyList(), Floor.C0, ToiletType.MALE),
        Toilet("C0WCM3", emptyList(), Floor.C0, ToiletType.MALE),
        Toilet("C0WCF1", emptyList(), Floor.C0, ToiletType.FEMALE),
        Toilet("C0WCF2", emptyList(), Floor.C0, ToiletType.FEMALE),
        Toilet("C0WCF3", emptyList(), Floor.C0, ToiletType.FEMALE),
        Multipurpose("C0M1", emptyList(), Floor.C0),
        Multipurpose("C0M2", emptyList(), Floor.C0),
        Multipurpose("C0M3", emptyList(), Floor.C0),
        Multipurpose("C0M4", emptyList(), Floor.C0),
        Connection("C0S1", emptyList(), Floor.C0, Direction.UP),
        Connection("C0S2", emptyList(), Floor.C0, Direction.DOWN),
        Connection("C0S3", emptyList(), Floor.C0, Direction.DOWN),
        Connection("C0E1", emptyList(),Floor.C0, Direction.OMNIDIRECTIONAL_VERTICAL),
        // C1
        Toilet("C1WCM1", emptyList(), Floor.C1, ToiletType.MALE),
        Toilet("C1WCM2", emptyList(), Floor.C1, ToiletType.MALE),
        Toilet("C1WCM3", emptyList(), Floor.C1, ToiletType.MALE),
        Toilet("C1WCF1", emptyList(), Floor.C1, ToiletType.FEMALE),
        Toilet("C1WCF2", emptyList(), Floor.C1, ToiletType.FEMALE),
        Toilet("C1WCF3", emptyList(), Floor.C1, ToiletType.FEMALE),
        Classroom("C101", emptyList(), Floor.C1),
        Classroom("C102", emptyList(), Floor.C1),
        Classroom("C103", emptyList(), Floor.C1),
        Classroom("C104", emptyList(), Floor.C1),
        Classroom("C105", emptyList(), Floor.C1),
        Classroom("C106", emptyList(), Floor.C1),
        Classroom("C107", emptyList(), Floor.C1),
        Classroom("C108", emptyList(), Floor.C1),
        Classroom("C109", emptyList(), Floor.C1),
        Classroom("C110", emptyList(), Floor.C1),
        Classroom("C111", emptyList(), Floor.C1),
        Classroom("C115", emptyList(), Floor.C1),
        Toilet("C1WCM1", emptyList(), Floor.C1, ToiletType.MALE),
        Toilet("C1WCM2", emptyList(), Floor.C1, ToiletType.MALE),
        Toilet("C1WCM3", emptyList(), Floor.C1, ToiletType.MALE),
        Toilet("C1WCF1", emptyList(), Floor.C1, ToiletType.FEMALE),
        Toilet("C1WCF2", emptyList(), Floor.C1, ToiletType.FEMALE),
        Toilet("C1WCF3", emptyList(), Floor.C1, ToiletType.FEMALE),
        Multipurpose("C1M1", emptyList(), Floor.C1),
        Multipurpose("C1M2", emptyList(), Floor.C1),
        Multipurpose("C1M3", emptyList(), Floor.C1),
        Multipurpose("C1M4", emptyList(), Floor.C1),
        Connection("C1S1", emptyList(), Floor.C1, Direction.UP),
        Connection("C1S2", emptyList(), Floor.C1, Direction.DOWN),
        Connection("C1S3", emptyList(), Floor.C1, Direction.DOWN),
        Connection("C1E1", emptyList(),Floor.C1, Direction.OMNIDIRECTIONAL_VERTICAL),
        // C2
        Toilet("C2WCM1", emptyList(), Floor.C2, ToiletType.MALE),
        Toilet("C2WCM2", emptyList(), Floor.C2, ToiletType.MALE),
        Toilet("C2WCM3", emptyList(), Floor.C2, ToiletType.MALE),
        Toilet("C2WCF1", emptyList(), Floor.C2, ToiletType.FEMALE),
        Toilet("C2WCF2", emptyList(), Floor.C2, ToiletType.FEMALE),
        Toilet("C2WCF3", emptyList(), Floor.C2, ToiletType.FEMALE),
        Classroom("C201", emptyList(), Floor.C2),
        Classroom("C202", emptyList(), Floor.C2),
        Classroom("C203", emptyList(), Floor.C2),
        Classroom("C204", emptyList(), Floor.C2),
        Classroom("C205", emptyList(), Floor.C2),
        Classroom("C206", emptyList(), Floor.C2),
        Classroom("C207", emptyList(), Floor.C2),
        Classroom("C208", emptyList(), Floor.C2),
        Classroom("C209", emptyList(), Floor.C2),
        Classroom("C210", emptyList(), Floor.C2),
        Classroom("C211", emptyList(), Floor.C2),
        Toilet("C2WCM1", emptyList(), Floor.C2, ToiletType.MALE),
        Toilet("C2WCM2", emptyList(), Floor.C2, ToiletType.MALE),
        Toilet("C2WCM3", emptyList(), Floor.C2, ToiletType.MALE),
        Toilet("C2WCF1", emptyList(), Floor.C2, ToiletType.FEMALE),
        Toilet("C2WCF2", emptyList(), Floor.C2, ToiletType.FEMALE),
        Toilet("C2WCF3", emptyList(), Floor.C2, ToiletType.FEMALE),
        Multipurpose("C2M1", emptyList(), Floor.C2),
        Multipurpose("C2M2", emptyList(), Floor.C2),
        Multipurpose("C2M3", emptyList(), Floor.C2),
        Multipurpose("C2M4", emptyList(), Floor.C2),
        Connection("C2S1", emptyList(), Floor.C2, Direction.UP),
        Connection("C2S2", emptyList(), Floor.C2, Direction.DOWN),
        Connection("C2S3", emptyList(), Floor.C2, Direction.DOWN),
        Connection("C2E1", emptyList(),Floor.C2, Direction.OMNIDIRECTIONAL_VERTICAL)

        //todo complete this list!!!
    )
) {

    fun addLocation(location: Location): Boolean {
        return locations.add(location)
    }

    fun getAllLocations(): List<Location> {
        return locations.toList()
    }

    fun getLocationByName(name: String): Location? {
        return locations.find { it.name.equals(name) }
    }

    fun getLocationsByFloor(floor: Floor): List<Location> {
        return locations.filter { it -> it.floor.equals(floor) }
    }

    fun getIndexOfLocationByName(name: String): Int {
        return locations.indexOf(getLocationByName(name))
    }

    fun updateLocation(location: Location): Boolean {
        if (locations.remove(getLocationByName(location.name))) {
            return locations.add(location)
        }
        return false
    }

    fun removeLocationByName(name: String) {
        locations.remove(getLocationByName(name))
    }

    fun removeAllLocations() {
        locations.clear()
    }
}