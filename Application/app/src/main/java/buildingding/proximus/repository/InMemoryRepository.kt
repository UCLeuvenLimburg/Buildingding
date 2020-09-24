package buildingding.proximus.repository

import buildingding.proximus.model.*

class InMemoryRepository (
    var locations: Set<Location> = setOf(
        Classroom("C101", emptyList(),Floor.C1),
        Classroom("C102", emptyList(),Floor.C1),
        Classroom("C103", emptyList(),Floor.C1),
        Classroom("C104", emptyList(),Floor.C1),
        Classroom("C105", emptyList(),Floor.C1),
        Classroom("C106", emptyList(),Floor.C1),
        Classroom("C107", emptyList(),Floor.C1),
        Classroom("C108", emptyList(),Floor.C1),
        Classroom("C109", emptyList(),Floor.C1),
        Classroom("C110", emptyList(),Floor.C1),
        Classroom("C111", emptyList(),Floor.C1),
        Toilet("C1WCM1", emptyList(), Floor.C1, ToiletType.MALE),
        Toilet("C1WCM2", emptyList(),Floor.C1, ToiletType.MALE),
        Toilet("C1WCM3", emptyList(),Floor.C1, ToiletType.MALE),
        Location("C111", emptyList(),Floor.C1)
    //todo complete this list!!!
    )
) {}