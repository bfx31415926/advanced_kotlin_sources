package f_03_property_delegation_2_lazy.myFile1

class B {
    init {
        println("B")
    }
}

class A {
    //Kotlin выводит тип свойства b
    // по возвращаемому значению лямбды в lazy { ... }.
    val b by lazy { B() }
}

fun main() {
    val a = A()
    a.b
}
/*
B
 */