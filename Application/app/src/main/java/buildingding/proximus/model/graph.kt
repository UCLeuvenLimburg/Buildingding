package buildingding.proximus.model

class Graph {
    var nodes: HashMap<Int, Location> = HashMap()

    fun addNode(node: Location) {
        nodes[node.id] = node
    }

    fun getNodeById(id: Int): Location? {
        return nodes[id]
    }
}