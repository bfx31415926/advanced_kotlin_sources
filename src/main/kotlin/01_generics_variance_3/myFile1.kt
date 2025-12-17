/*
Конструктор принимает T.
В init вызывается private set(), чтобы установить значение.
T остаётся out, публичный API не принимает T — всё безопасно.
см. также 01_generics_variance_3/2.kt
 */

package f_01_generics_variance_3.myFile1

class Box<out T>(value: T) {
    private var value: T? = null

    init {
        set(value) // используем приватный метод
    }

    private fun set(value: T) {
        this.value = value
    }

    fun get(): T = value ?: error("Value not set")
}

fun main() {
    val box: Box<String> = Box("Hello")
    println(box.get()) // вывод: Hello
}

/*
Hello
*/