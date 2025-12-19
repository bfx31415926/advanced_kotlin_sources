import kotlin.reflect.KClass

sealed class LinkedList<out T>

class Node<out T>(
    val head: T,
    val next: LinkedList<T>
) : LinkedList<T>()

object Empty : LinkedList<Nothing>()

fun printInstance(c: KClass<*>) {
    println(c.objectInstance)
}

fun main() {
    println( LinkedList::class.sealedSubclasses )

    printInstance(Node::class) // null
    printInstance(Empty::class) // Empty@XYZ (фишка в том,
                                    // что object при объявлении сразу создается)
}
/*
[class Empty, class Node]
null
Empty@xyz
 */