package f_09_reflection_2.s_10

class User<Task>

fun main() {
    println(List::class.typeParameters) // [out E]
    println(Map::class.typeParameters) // [K, out V]
    println(User::class.typeParameters) // [Task]
}
/*
[out E]
[K, out V]
[Task]
 */