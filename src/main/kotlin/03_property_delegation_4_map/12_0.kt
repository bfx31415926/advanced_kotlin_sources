package f_03_property_delegation_4_map.s_12_0

class Population(var cities: Map<String, Int>) {
    val sanFrancisco by cities
    val tallinn by cities
    val kotlin by cities
}

var population = Population(
    mapOf(
        "sanFrancisco" to 864_816,
        "tallinn" to 413_782,
        "kotlin" to 43_005
    )
)

fun main(args: Array<String>) {
    population = Population(emptyMap())
//    population.cities = emptyMap()
    println(population.sanFrancisco)
    println(population.tallinn)
    println(population.kotlin)
}
/*
Exception in thread "main" java.util.NoSuchElementException: Key sanFrancisco is missing in the map.
	at kotlin.collections.MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(MapWithDefault.kt:24)
	at f_03_property_delegation_4_map.s_12_0.Population.getSanFrancisco(12_0.kt:4)
	at f_03_property_delegation_4_map.s_12_0._12_0Kt.main(12_0.kt:20)
 */