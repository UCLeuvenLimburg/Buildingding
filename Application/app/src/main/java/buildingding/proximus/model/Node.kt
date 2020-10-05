package buildingding.proximus.model

import java.util.concurrent.atomic.AtomicInteger

class Node(var name: String) {
    val id: Int
    var distance = Int.MAX_VALUE
    private var adjacentNodes: MutableMap<Node, Int> = HashMap()
    fun getAdjacentNodeDistance(node: Node): Int {
        return adjacentNodes[node]!!
    }

    fun addDestination(destination: Node, distance: Int) {
        adjacentNodes[destination] = distance
    }

    fun getAdjacentNodes(): Map<Node, Int> {
        return adjacentNodes
    }

    fun setAdjacentNodes(adjacentNodes: MutableMap<Node, Int>) {
        this.adjacentNodes = adjacentNodes
    }

    companion object {
        private val count: AtomicInteger = AtomicInteger(0)
    }

    init {
        id = count.incrementAndGet()
    }
}