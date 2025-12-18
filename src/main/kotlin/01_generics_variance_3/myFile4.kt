package f_01_generics_variance_3.myFile4

fun printList(list: List<Any?>) {
    println(list)
}

fun main() {
    printList(listOf(1, 2, null))
    printList(listOf("aa", null, "cc"))
}
/*
[1, 2, null]
[aa, null, cc]
 */