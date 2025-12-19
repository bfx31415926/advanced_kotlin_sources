package f_09_reflection_1.myPage220

import kotlin.reflect.KCallable

operator fun String.times(times: Int) = this.repeat(times)
fun main() {
    val f: KCallable<String> = String::times
    println(f.name) // times
    println(f.parameters.map { it.name }) // [null, times]
    println(f.returnType) // kotlin.String
    println(f.typeParameters) // []
    println(f.visibility) // PUBLIC
    println(f.isFinal) // true
    println(f.isOpen) // false
    println(f.isAbstract) // false
    println(f.isSuspend) // false
}
/*
times
[null, times]
kotlin.String
[]
PUBLIC
true
false
false
false
 */