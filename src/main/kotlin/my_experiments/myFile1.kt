package my_experiments.myFile1

import java.lang.reflect.Field
import kotlin.reflect.full.memberProperties

fun Any.toJson(): String = objectToJson(this)

private fun objectToJson(any: Any) = any::class
    .memberProperties
    .joinToString(
        prefix = "{",
        postfix = "}",
        transform = { prop ->
            "\"${prop.name}\": ${valueToJson(prop.call(any))}"
        }
    )

private fun valueToJson(value: Any?): String = when (value) {
    null, is Number -> "$value"
    is String, is Enum<*> -> "\"$value\""
// ...
    else -> objectToJson(value)
}

enum class Gender {
    MALE,
    FEMALE
}

class User(val name: String, val age: Int, val gender: Gender, val weight: Int){
//    protected val prot = 15
//    private val priv = 16
}

fun main() {
    val user = User("Alex", 66, Gender.MALE, 84 )
    val jsonString = user.toJson()
    println(jsonString)
}
/*
{"age": 66, "gender": "MALE", "name": "Alex", "weight": 84}
 */
