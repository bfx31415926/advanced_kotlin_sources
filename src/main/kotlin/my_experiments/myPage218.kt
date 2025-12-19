package my_experiments.myPage218
import kotlin.reflect.KFunction2

fun add(i: Int, j: Int) = i + j
fun main() {
//    val f: KFunction2<Int, Int, Int> = ::add
    val f:KFunction2<Int, Int, Int> = ::add
    println(f(1, 2)) // 3
    println(f.invoke(1, 2)) // 3
}
/*
3
3
 */