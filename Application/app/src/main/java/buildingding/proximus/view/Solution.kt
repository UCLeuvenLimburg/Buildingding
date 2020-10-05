package buildingding.proximus.view

import buildingding.proximus.model.Dijkstra
import buildingding.proximus.model.Graph
import buildingding.proximus.model.Node


object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        val C001 = Node("C001")
        val C002 = Node("C002")
        val C003 = Node("C003")
        val C004 = Node("C004")
        val C005 = Node("C005")
        val C006 = Node("C006")
        C001.addDestination(C002, 10)
        C001.addDestination(C003, 15)
        C002.addDestination(C004, 12)
        C002.addDestination(C006, 15)
        C003.addDestination(C005, 10)
        C004.addDestination(C005, 2)
        C004.addDestination(C006, 1)
        C006.addDestination(C005, 5)
        val graph = Graph()
        graph.addNode(C001)
        graph.addNode(C002)
        graph.addNode(C003)
        graph.addNode(C004)
        graph.addNode(C005)
        graph.addNode(C006)
        val m = Array(graph.nodes.size) { IntArray(graph.nodes.size) }
        for (i in m.indices) {
            val ni: Node? = graph.getNodeById(i + 1)
            for (j in m[i].indices) {
                val nj: Node? = graph.getNodeById(j + 1)
                if (!ni!!.getAdjacentNodes().containsKey(nj)) {
                    m[i][j] = 0
                } else {
                    m[i][j] = nj?.let { ni.getAdjacentNodeDistance(it) }!!
                }
            }
        }
        val haha = Dijkstra(m)
        println("\n All paths: \n")
        println(haha.calculatePaths(C004.id, graph.nodes))
    }
}