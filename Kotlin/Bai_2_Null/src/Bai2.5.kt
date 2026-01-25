fun main() {
    var phone: String? = "+84123456789"
    val doDai = phone?.length ?:0
//    if (doDai >= 10) {
//        println("Số hợp lệ")
//    } else {
//        println("số ko hợp lệ")
//    }

    val output: String = if (doDai >= 10) "Số hợp lệ" else "Số ko hợp lệ"
    println(output)
}