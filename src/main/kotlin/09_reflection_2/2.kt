import kotlin.reflect.KClass

open class A1
class B1 : A1()

fun main() {
    val a1: A1 = B1()
    val clazz: KClass<out A1> = a1::class
    println(clazz) // class B1
}
/*
class B1
 */