package my_experiments.myPages241

import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.full.memberProperties
// Serialization function definition

// Annotations
@Target(AnnotationTarget.PROPERTY)
annotation class JsonName(val name: String)

@Target(AnnotationTarget.PROPERTY)
annotation class JsonIgnore

fun Any.toJson(): String = objectToJson(this)

private fun objectToJson(any: Any) = any::class
    .memberProperties
    .filterNot { it.hasAnnotation<JsonIgnore>() }
    .joinToString(
        prefix = "{",
        postfix = "}",
        transform = { prop ->
            val annotation = prop.findAnnotation<JsonName>()
            val name = annotation?.name ?: prop.name
            "\"${name}\": ${valueToJson(prop.call(any))}"
        }
    )

private fun valueToJson(value: Any?): String = when (value) {
    null, is Number, is Boolean -> "$value"
    is String, is Enum<*> -> "\"$value\""
    is Iterable<*> -> iterableToJson(value)
    is Map<*, *> -> mapToJson(value)
    else -> objectToJson(value)
}

private fun iterableToJson(any: Iterable<*>): String = any
    .joinToString(
        prefix = "[",
        postfix = "]",
        transform = ::valueToJson
    )

private fun mapToJson(any: Map<*, *>) = any.toList()
    .joinToString(
        prefix = "{",
        postfix = "}",
        transform = {
            "\"${it.first}\": ${valueToJson(it.second)}"
        }
    )

// Example use
class Creature(
    @JsonIgnore val name: String,
    @JsonName("att") val attack: Int,
    @JsonName("def") val defence: Int,
    val traits: List<Trait>,
    val cost: Map<Element, Int>
)

enum class Element {
    FOREST, ANY,
}

enum class Trait {
    FLYING
}

fun main() {
    val creature = Creature(
        name = "Cockatrice",
        attack = 2,
        defence = 4,
        traits = listOf(Trait.FLYING),
        cost = mapOf(
            Element.ANY to 3,
            Element.FOREST to 2
        )
    )
    println(creature.toJson())
}
/*
{"att": 2, "cost": {"ANY": 3, "FOREST": 2}, "def": 4, "traits": ["FLYING"]}
 */