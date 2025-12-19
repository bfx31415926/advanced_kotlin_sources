object OBJECT {}

fun main() {
    val o = object {}
    val clazz = o::class
    println(clazz.simpleName) // null
    println(clazz.qualifiedName) // null

    val o1 = OBJECT
    val clazz1 = o1::class
    println(clazz1.simpleName) // OBJECT
    println(clazz1.qualifiedName) // OBJECT
}
/*
null
null
OBJECT
OBJECT
 */