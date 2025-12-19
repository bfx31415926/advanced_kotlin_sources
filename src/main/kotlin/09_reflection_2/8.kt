import kotlin.reflect.full.superclasses

interface I1
interface I2
open class A1 : I1
class B : A1(), I2

fun main() {
    val a = A1::class
    val b = B::class
    println(a.superclasses) // [class I1, class kotlin.Any]
    println(b.superclasses) // [class A1, class I2]
    println(a.supertypes) // [I1, kotlin.Any]
    println(b.supertypes) // [A1, I2]
}
/*
[class I1, class kotlin.Any]
[class A1, class I2]
[I1, kotlin.Any]
[A1, I2]
 */