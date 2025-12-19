package f_09_reflection_1.s_4

import kotlin.reflect.KCallable

fun sendEmail(
    email: String,
    title: String = "",
    message: String = ""
) {
    println(
        """
       Sending to $email
       Title: $title
       Message: $message
   """.trimIndent()
    )
}

fun main() {
    val f: KCallable<Unit> = ::sendEmail

    f.callBy(mapOf(f.parameters[0] to "ABC"))
    // Sending to ABC
    // Title:
    // Message:

    val params = f.parameters.associateBy { it.name }
    println("params = $params")
    f.callBy(
        mapOf(
            params["title"]!! to "DEF",
            params["message"]!! to "GFI",
            params["email"]!! to "ABC",
        )
    )
    // Sending to ABC
    // Title: DEF
    // Message: GFI

    f.callBy(mapOf()) // throws IllegalArgumentException
}
/*
Sending to ABC
Title:
Message:
Sending to ABC
Title: DEF
Message: GFI
Exception in thread "main" java.lang.IllegalArgumentException: No argument provided for a required parameter: parameter #0 email of fun sendEmail(kotlin.String, kotlin.String, kotlin.String): kotlin.Unit
	at kotlin.reflect.jvm.internal.KCallableImpl.callDefaultMethod$kotlin_reflection(KCallableImpl.kt:238)
	at kotlin.reflect.jvm.internal.KCallableImpl.callBy(KCallableImpl.kt:155)
	at kotlin.jvm.internal.CallableReference.callBy(CallableReference.java:166)
	at f_09_reflection_1.s_4._4Kt.main(4.kt:39)
	at f_09_reflection_1.s_4._4Kt.main(4.kt)
 */