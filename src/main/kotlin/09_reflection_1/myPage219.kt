package f_09_reflection_1.myPage219

import kotlin.reflect.KFunction

inline infix operator fun String.times(times: Int) =
    this.repeat(times)

fun main() {
    val f: KFunction<String> = String::times
    println(f.isInline) // true
    println(f.isExternal) // false
    println(f.isOperator) // true
    println(f.isInfix) // true
    println(f.isSuspend) // false
}
/*
true
false
true
true
false
*/