package buildingding.proximus.view

import buildingding.proximus.model.*


object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        val locationC001 = Location("C001", Floor.C0)
        val locationC002 = Location("C002", Floor.C0)
        val locationC003 = Location("C003", Floor.C0)
        val locationC004 = Location("C004", Floor.C0)
        val locationC005 = Location("C005", Floor.C0)
        val locationC006 = Location("C006", Floor.C0)
        locationC001.addDestination(locationC002, 10)
        locationC001.addDestination(locationC003, 15)
        locationC002.addDestination(locationC004, 12)
        locationC002.addDestination(locationC006, 15)
        locationC003.addDestination(locationC005, 10)
        locationC004.addDestination(locationC005, 2)
        locationC004.addDestination(locationC006, 1)
        locationC006.addDestination(locationC005, 5)
        val graph = Graph()
        graph.addNode(locationC001)
        graph.addNode(locationC002)
        graph.addNode(locationC003)
        graph.addNode(locationC004)
        graph.addNode(locationC005)
        graph.addNode(locationC006)
        val m = Array(graph.nodes.size) { IntArray(graph.nodes.size) }
        for (i in m.indices) {
            val ni: Location? = graph.getNodeById(i + 1)
            for (j in m[i].indices) {
                val nj: Location? = graph.getNodeById(j + 1)
                if (!ni!!.getNeighbours().containsKey(nj)) {
                    m[i][j] = 0
                } else {
                    m[i][j] = nj?.let { ni.getAdjacentNeighbourDistance(it) }!!
                }
            }
        }
        val dijkstra = Dijkstra(m)
        println("\n All paths: \n")
        println(dijkstra.calculatePaths(locationC004.id, graph.nodes))
    }
}