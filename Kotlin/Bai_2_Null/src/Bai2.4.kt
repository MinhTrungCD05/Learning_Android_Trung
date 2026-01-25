fun main() {
    val score: Int = readLine()!!.toInt()
    var result: String = "Rớt"

    if (score >= 5) {
        result = "đậu"
    }

    println(result)
}