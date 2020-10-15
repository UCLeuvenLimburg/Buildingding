package buildingding.proximus.repository


import java.util.*

object TextDirections {
    val initialSentences: Queue<String> = LinkedList<String>()
    val sentences: Queue<String> = LinkedList<String>()

    fun getNextDirection(location: String?): String {
        val next = sentences.poll()
        sentences.offer(next)
        return "$next $location"
    }

    fun addDirections(directions: List<String>) {
        initialSentences.addAll(directions)
        sentences.addAll(directions)
    }

    fun resetDirections() {
        sentences.clear()
        sentences.addAll(initialSentences)
    }
}