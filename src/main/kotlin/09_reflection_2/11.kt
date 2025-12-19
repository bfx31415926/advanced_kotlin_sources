class A3 {
    class B3
    inner class C3
}

fun main() {
    println(A3::class.nestedClasses)
    println("Типы внутренних классов A3:")
    for (nestedClass in A3::class.nestedClasses) {
        when {
            nestedClass.isInner -> println("Inner: ${nestedClass.simpleName}")
            else -> println("Static nested: ${nestedClass.simpleName}")
        }
    }
}
/*
[class A3$B3, class A3$C3]
Типы внутренних классов A3:
Static nested: B3
Inner: C3
 */