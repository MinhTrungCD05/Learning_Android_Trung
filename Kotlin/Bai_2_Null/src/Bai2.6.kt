fun main() {
    val age: Int = readLine()!!.toInt()

    if (age < 12){
        println("Trẻ em")
    } else if (age >= 18){
        println("Người lớn")
    } else println("Thiếu niên")
}