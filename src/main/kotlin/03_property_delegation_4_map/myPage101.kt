package f_03_property_delegation_4_map.myPage101

interface Nameable {
    val name: String
}

fun main() {
    var user1: Nameable = object : Nameable {
        override var name: String = "Rafał"
    }
    val user2 = user1
    user1 = object : Nameable {
        override var name: String = "Bartek"
    }
    println(user2.name)
}
/*
Rafał
 */