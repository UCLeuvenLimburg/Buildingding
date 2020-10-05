package buildingding.proximus.model

class Dijkstra(matrix: Array<IntArray>?) {
    private val tomatrix: Array<IntArray>
    private fun initMatrixDijkstra(startLocation: Int): Array<IntArray> {
        val res = Array(tomatrix.size + 1) { IntArray(tomatrix.size) }
        // to initialize start location first set first row with infinite value, to find the SPF
        for (i in tomatrix.indices) res[0][i] = Int.MAX_VALUE
        for (i in 1..tomatrix.size) {
            for (j in tomatrix.indices) {
                if (tomatrix[i - 1][j] == Int.MAX_VALUE) {
                    res[i][j] = 0
                } else {
                    res[i][j] = tomatrix[i - 1][j]
                }
            }
        }
        for (i in tomatrix.indices) {
            res[i][startLocation - 1] = 0
        }
        return res
    }

    fun algorithm(startLocation: Int): Array<IntArray> {
        val res = initMatrixDijkstra(startLocation)
        println("Initialization matrix: \n")
        printIntMatrix(res)
        var ok = false
        while (!ok) {
            var indexSmallestJ = 0
            var indexSmallestI = 0
            var smallest = Int.MAX_VALUE
            for (i in tomatrix.indices) {
                if (res[0][i] != Int.MAX_VALUE) {
                    // Evaluation phase:
                    // search for all nodes for which there is no shortest path yet from nodes that might still have, together with smallest distance
                    for (j in tomatrix.indices) {
                        if (res[i + 1][j] != 0 && res[0][j] == Int.MAX_VALUE) if (res[0][i] + res[i + 1][j] < smallest) {
                            indexSmallestJ = j
                            indexSmallestI = i + 1
                            smallest = res[0][i] + res[i + 1][j]
                        }
                    }
                }
            }
            if (smallest == Int.MAX_VALUE) {
                ok = true
            } else {
                res[0][indexSmallestJ] = smallest
                for (i in 1..tomatrix.size) if (i != indexSmallestI) {
                    res[i][indexSmallestJ] = 0
                }
            }
        }
        return res
    }

    private fun findPathString(startLocation: Int, toLocation: Int, res: Array<IntArray>, nodes: HashMap<Int, Node>): ArrayList<String> {
        var toLocation = toLocation
        val pad: ArrayList<String> = ArrayList()
        pad.add(nodes[toLocation]!!.name)
        while (toLocation != startLocation) {
            var k = 1
            while (k < res.size && res[k][toLocation - 1] == 0) k++
            pad.add(0, nodes[k]!!.name)
            toLocation = k
        }
        return pad
    }

    fun calculatePaths(startLocation: Int, nodes: HashMap<Int, Node>): String {
        var uit = ""
        val res = algorithm(startLocation)
        println("Evaluation matrix: \n")
        printIntMatrix(res)
        for (i in 0 until res[0].size) {
            if (i + 1 != startLocation) {
                if (res[0][i] == Int.MAX_VALUE) {
                    uit += """There is no path from ${nodes[startLocation]!!.name.toString()} to ${nodes[i + 1]!!.name.toString()}
"""
                } else {
                    uit += """Shortest distance from ${nodes[startLocation]!!.name.toString()} to ${nodes[i + 1]!!.name.toString()} = ${res[0][i]}
"""
                    uit += "via "
                    val j = i + 1
                    val pad = findPathString(startLocation, j, res, nodes)
                    uit += """
                        $pad
                        
                        """.trimIndent()
                }
            }
        }
        return uit
    }

    fun getPath(startLocation: Int, destination: Int, nodes: HashMap<Int, Node>): List<String> {
        var out: List<String> = ArrayList()
        val matrix = algorithm(startLocation)
        println("Evaluation matrix: \n")
        printIntMatrix(matrix)
        for (i in 0 until matrix[0].size) {
            if (i + 1 != startLocation) {
                if (matrix[0][i] == Int.MAX_VALUE) {
                } else {
                    val j = i + 1
                    if (j == destination) {
                        out = findPathString(startLocation, j, matrix, nodes)
                    }
                }
            }
        }
        return out
    }

    private fun findpath(startLocation: Int, toLocation: Int, res: Array<IntArray>, nodes: HashMap<Int, Node>): ArrayList<Node?> {
        var toLocation = toLocation
        val path: ArrayList<Node?> = ArrayList()
        path.add(nodes[toLocation])
        while (toLocation != startLocation) {
            var k = 1
            while (k < res.size && res[k][toLocation - 1] == 0) k++
            path.add(0, nodes[k])
            toLocation = k
        }
        return path
    }

    companion object {
        private fun printIntMatrix(matrix: Array<IntArray>) {
            var result = ""
            for (i in matrix.indices) {
                for (j in 0 until matrix[0].size) {
                    result += (if (matrix[i][j] == Int.MAX_VALUE) "inf" else matrix[i][j]).toString() + "\t"
                }
                result += "\n"
            }
            result += "\n"
            println(result)
        }
    }

    init {
        require(!(matrix == null || matrix.size == 0 || matrix.size != matrix[0].size))
        tomatrix = matrix.clone()
    }
}