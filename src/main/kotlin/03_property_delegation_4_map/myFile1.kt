package f_03_property_delegation_4_map.myFile1

fun main() {
    var map = mapOf(1 to 1, 2 to 2)
    map = emptyMap()
    var mmMap = mutableMapOf(1 to 1, 2 to 2)
    mmMap = mutableMapOf() //т.к.emptyMap() компилятору не нравится.
    println(mmMap)
}
/*
{}
 */