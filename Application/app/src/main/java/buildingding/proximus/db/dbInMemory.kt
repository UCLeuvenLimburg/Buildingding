package buildingding.proximus.db

import buildingding.proximus.model.Classroom
import buildingding.proximus.model.Location
import buildingding.proximus.model.Utility

class dbInMemory (
    var locations: Set<Location> = setOf(
        Classroom("C101a"),
        Classroom("C101"),
        Classroom("C102"),
        Classroom("C103"),
        Classroom("C104"),
        Classroom("C105"),
        Classroom("C106"),
        Classroom("C107"),
        Classroom("C108"),
        Classroom("C109"),
        Classroom("C110"),
        Classroom("C111"),
        Utility("C1WCM1"),
        Utility("C1WCM1"),
        Utility("C1WCM1"),
        Utility("C111")
    )
) {}