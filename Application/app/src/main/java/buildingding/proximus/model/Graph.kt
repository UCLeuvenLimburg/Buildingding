package buildingding.proximus.model

class Graph(private val nodes: HashMap<Int, Location>) {

    fun getPriorityQueue(): Array<IntArray> {
        val priorityQueue = Array(nodes.size) { IntArray(nodes.size) }
        for (i in priorityQueue.indices) {
            val ni: Location? = nodes[(i + 1)]
            for (j in priorityQueue[i].indices) {
                val nj: Location? = nodes[(j + 1)]
                if (!ni!!.neighbours.containsKey(nj)) {
                    priorityQueue[i][j] = 0
                } else {
                    priorityQueue[i][j] = nj?.let { ni.getAdjacentNeighbourDistance(it) }!!
                }
            }
        }
        return priorityQueue
    }
}