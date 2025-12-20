/*
Значения полей можно узнать только через Java - рефлексию
Этот файл демонстрирует, что можно узнать через Java-рефлексию
а что через Kotlin-рефлексию
 */
package my_experiments.myFile2

import java.lang.reflect.Field
import java.lang.reflect.Modifier
import kotlin.reflect.full.memberProperties

//fun Any.toJson(): String = objectToJson(this)
//
//private fun objectToJson(any: Any) = any::class
//    .memberProperties
//    .joinToString(
//        prefix = "{",
//        postfix = "}",
//        transform = { prop ->
//            "\"${prop.name}\": \"${valueToJson(prop.call(any))}\""
//        }
//    )
//
//fun valueToJson(any: Any?): String = any.toString()

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

    println("fields / properties.size = ${fields.size}")

    println("Свойства (с точки зрения Kotlin):")
    for (prop in User::class.memberProperties) {
        println("Свойство: ${prop.name}")
        println("  Доступ: ${prop.visibility}")
        println("  Final: ${prop.isFinal}")
        println()
    }

    println("Поля (с точки зрения Java):")
    for (field in fields) {
        val modifiers = field.modifiers

        // Получаем строковое представление модификаторов
        val modifiersString = Modifier.toString(modifiers)

        println("Поле: ${field.name}")
        println("  Модификаторы: $modifiersString")
        println("  Тип: ${field.type.simpleName}")

        // Определяем уровень доступа
        when {
            Modifier.isPublic(modifiers) -> println("  Доступ: public")
            Modifier.isProtected(modifiers) -> println("  Доступ: protected")
            Modifier.isPrivate(modifiers) -> println("  Доступ: private")
            else -> println("  Доступ: internal (package-private)")
        }

        // Проверяем другие флаги
        if (Modifier.isStatic(modifiers)) println("  Статическое: да")
        if (Modifier.isFinal(modifiers)) println("  Final: да")
        if (Modifier.isTransient(modifiers)) println("  Transient: да")
        if (Modifier.isVolatile(modifiers)) println("  Volatile: да")

        // Читаем значение
        field.isAccessible = true
        val value = try {
            field.get(obj)
        } catch (e: Exception) {
            "Ошибка при чтении: ${e.javaClass.simpleName}"
        }
        println("  Значение: $value")
        println()
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
