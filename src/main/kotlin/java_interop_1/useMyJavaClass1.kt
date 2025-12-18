package java_interop_11

import java_interop_1.*

fun main() {
    println(JavaClass1(1).id)
    println(JavaClass1.produceNonNullable())
    println(JavaClass1.produceNullable())
}
/*
1
ABC
null
 */
