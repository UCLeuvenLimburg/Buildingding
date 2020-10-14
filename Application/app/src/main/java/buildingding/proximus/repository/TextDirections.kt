package buildingding.proximus.repository


import java.util.*

object TextDirections {
    val sentences: Queue<String> = LinkedList<String>()

    fun getNextDirection(location: String?): String {
        val next = sentences.poll()
        sentences.offer(next)
        return "$next $location"
    }
}