package buildingding.proximus.model

class Graph {
    var nodes: HashMap<Int, Node> = HashMap()

    fun addNode(nodeA: Node) {
        nodes[nodeA.id] = nodeA
    }

    fun getNodeById(id: Int): Node? {
        return nodes[id]
    }
}