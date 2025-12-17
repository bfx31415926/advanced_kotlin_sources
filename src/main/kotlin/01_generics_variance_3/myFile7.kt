/*
см. файл myFile6.kt
 */
package f_01_generics_variance_3.myFile7

sealed class Response<R, E>
class Success<R, E>(val value: R) : Response<R, E>()
class Failure<R, E>(val error: E) : Response<R, E>()

// Фабричные функции — помогают выводу типов
fun <R> success(value: R): Success<R, Nothing> = Success(value)
fun <E> failure(error: E): Failure<Nothing, E> = Failure(error)

fun main() {
    val rs11 = success(1)
    println("rs11.value = ${rs11.value}")
    val rs22 = success("ABC")
    println("rs22.value = ${rs22.value}")
    val re11 = failure(Error())
    println("re11.error.toString() = ${re11.error.toString()}")
    val re22 = failure("Error")
    println("re22.error = ${re22.error}")
}
/*
rs11.value = 1
rs22.value = ABC
re11.error.toString() = java.lang.Error
re22.error = Error
 */