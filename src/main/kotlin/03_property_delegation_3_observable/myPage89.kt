package f_03_property_delegation_3_observable.myPage89

import kotlin.properties.Delegates.observable

var name: String by observable("Empty") { prop, old, new ->
    println("$old -> $new")
}

fun main() {
    name = "Martin" // Empty -> Martin
    name = "Igor" // Martin -> Igor
    name = "Igor" // Igor -> Igor
}
/*
Empty -> Martin
Martin -> Igor
Igor -> Igor
 */