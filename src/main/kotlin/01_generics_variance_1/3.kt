package f_01_generics_variance_1.s_3

fun printProcessedNumber(transformation: (Int) -> Any) {
    println(transformation(42))
}

val intToDouble: (Int) -> Number = { it.toDouble() }
val numberAsText: (Number) -> String = { it.toString() }
val identity: (Number) -> Number = { it }
val numberToInt: (Number) -> Int = { it.toInt() }
val numberHash: (Any) -> Number = { it.hashCode() }

fun main() {
    printProcessedNumber(intToDouble)
    printProcessedNumber(numberAsText)
    printProcessedNumber(identity)
    printProcessedNumber(numberToInt)
    printProcessedNumber(numberHash)
}
/*
42.0
42
42
42
42
 */