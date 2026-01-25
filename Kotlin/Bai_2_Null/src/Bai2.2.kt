// Lấy độ dài của chuỗi, nếu là null lấy ra = 0
fun main() {
    val kTra: String? = null
    val name: String? = null
    // độ dài
    kTra?.let {
        println("Độ dài của chuỗi kTra là:" + kTra.length )
    }
    println("Tên null")
    // chương trình ko đc crash khi name = null
    name?.let {
        println("Độ dài của chuỗi name là:" + name.length )
    }
}