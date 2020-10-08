package buildingding.proximus.model

class AccessPoint(val SSID: String, val BSSID: String, var level: Int, var timestamp: Long, val locations: Map<String, Pair<Int,Int>>) {
}