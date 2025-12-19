package my_experiments.myFile2

import java.lang.reflect.Field
import kotlin.reflect.full.memberProperties

fun Any.toJson(): String = objectToJson(this)

private fun objectToJson(any: Any) = any::class
    .memberProperties
    .joinToString(
        prefix = "{",
        postfix = "}",
        transform = { prop ->
            "\"${prop.name}\": \"${valueToJson(prop.call(any))}\""
        }
    )

fun valueToJson(any: Any?): String = any.toString()

enum class Gender {
    MALE,
    FEMALE
}

class User(val name: String, val age: Int, val gender: Gender, val weight: Int){
    protected val prot = 15
    private val priv = 16
}

fun printAllFields(obj: Any) {
    val clazz = obj.javaClass
    val fields: Array<Field> = clazz.declaredFields
    println(fields.size)
    for (field in fields) {
        field.isAccessible = true // обходим private
        val value = field.get(obj) // читаем значение поля
        println("Field: ${field.name}, Value: $value")
    }
}

fun main() {
    val user = User("Alex", 66, Gender.MALE, 84 )
    printAllFields( user)
}
/*
6
Field: name, Value: Alex
Field: age, Value: 66
Field: gender, Value: MALE
Field: weight, Value: 84
Field: prot, Value: 15
Field: priv, Value: 16
 */
