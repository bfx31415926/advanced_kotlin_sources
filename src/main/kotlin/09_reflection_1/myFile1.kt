package f_09_reflection_1.myFile1

import kotlin.reflect.KFunction

fun add(x: Int, y: Int) = x + y

fun main() {
    val f: KFunction<Int> = ::add
    println(f.isInline)
    println(f.isExternal)
    println(f.isOperator)
    println(f.isInfix)
    println(f.isSuspend)
}
/*
false
false
false
false
false
*/