
fun main() {
    val age: Int = readLine()!!.toInt()
    println("Your age is $age")
    val output: String = if (age < 18) "chưa đủ tuổi" else "đủ tuổi"
    println(output)
}
