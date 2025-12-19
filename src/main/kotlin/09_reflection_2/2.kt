import kotlin.reflect.KClass

open class A2
class B1 : A2()

fun main() {
    val a2: A2 = B1()
    val clazz: KClass<out A2> = a2::class
    println(clazz) // class B1
}
/*
class B1
 */