package f_09_reflection_3.s_4

import kotlin.reflect.*

class Box<T>(val value: T) {
    fun get(): T = value
}

fun main() {
    val t1 = typeOf<List<Int>>()
    println(t1) // kotlin.collections.List<kotlin.Int>
    println(t1.classifier) // class kotlin.collections.List
    println(t1.classifier is KClass<*>) // true
    println(t1 is KType) // true
    println(t1 is KClass<*>) // false
    val t2 = typeOf<Map<Long, Char>>()
    println(t2.classifier) // class kotlin.collections.Map
    println(t2.arguments[0].type?.classifier) // class kotlin.Long

    val t3 = Box<Int>::get.returnType.classifier
    println(t3) // T
    println(t3 is KTypeParameter) // true
    val kTypeParameter = t3 as KTypeParameter
    println("kTypeParameter.name = ${kTypeParameter.name},\n" +
            "kTypeParameter.upperBounds = ${kTypeParameter.upperBounds},\n" +
            "kTypeParameter.variance = ${kTypeParameter.variance},\n" +
            "kTypeParameter.isReified = ${kTypeParameter.isReified}")
}
/*
kotlin.collections.List<kotlin.Int>
class kotlin.collections.List
true
true
false
class kotlin.collections.Map
class kotlin.Long
T
true
kTypeParameter.name = T,
kTypeParameter.upperBounds = [kotlin.Any?],
kTypeParameter.variance = INVARIANT,
kTypeParameter.isReified = false
 */