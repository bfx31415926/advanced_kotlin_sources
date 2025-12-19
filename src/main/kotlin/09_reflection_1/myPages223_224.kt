package f_09_reflection_1.myPage223_224

import kotlin.reflect.KCallable
import kotlin.reflect.KParameter
import kotlin.reflect.typeOf

fun callWithFakeArgs(callable: KCallable<*>) {
    val arguments = callable.parameters
        .filterNot { it.isOptional }
        .associateWith { fakeValueFor(it) }
    callable.callBy(arguments)
}

fun fakeValueFor(parameter: KParameter) =
    when (parameter.type) {
        typeOf<String>() -> "Fake ${parameter.name}"
        typeOf<Int>() -> 123
        else -> error("Unsupported type")
    }

fun sendEmail(
    email: String,
    title: String,
    message: String = ""
) {
    println("""
Sending to $email
Title: $title
Message: $message
""".trimIndent()
    )
}

fun printSum(a: Int, b: Int) {
    println(a + b)
}

fun Int.printProduct(b: Int) {
    println(this * b)
}

fun main() {
    callWithFakeArgs(::sendEmail)
// Sending to Fake email
// Title: Fake title
// Message:
    callWithFakeArgs(::printSum) // 246
    callWithFakeArgs(Int::printProduct) // 15129
}
/*
Sending to Fake email
Title: Fake title
Message:
246
15129
 */