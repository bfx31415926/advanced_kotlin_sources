package f_09_reflection_1.s_3

import kotlin.reflect.KCallable

fun add(i: Int, j: Int) = i + j

fun main() {
    val f: KCallable<Int> = ::add
    println(f.call(1, 2)) // 3
    println(f.call("A", "B")) // IllegalArgumentException
}
/*
3
Exception in thread "main" java.lang.IllegalArgumentException: argument type mismatch
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:107)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at kotlin.reflect.jvm.internal.calls.CallerImpl$Method.callMethod(CallerImpl.kt:97)
	at kotlin.reflect.jvm.internal.calls.CallerImpl$Method$Static.call(CallerImpl.kt:106)
	at kotlin.reflect.jvm.internal.KCallableImpl.call(KCallableImpl.kt:151)
	at kotlin.jvm.internal.CallableReference.call(CallableReference.java:161)
	at f_09_reflection_1.s_3._3Kt.main(3.kt:10)
	at f_09_reflection_1.s_3._3Kt.main(3.kt)
 */