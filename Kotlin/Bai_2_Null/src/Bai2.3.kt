fun main() {

    var username: String? = null
    username = readLine()!!.trim()
    println(username ?: "Khách")
}