package f_03_property_delegation_1.myPage67

import kotlin.reflect.KProperty

class EmptyPropertyDelegate {
    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): String {
        return ""
    }
    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: String
    ) {
// no-op
    }
}
val p1: String by EmptyPropertyDelegate()
var p2: String by EmptyPropertyDelegate()

fun main() {
    println("p1 = $p1, p2 = $p2")
    p2 = "Hello"
    println("p1 = $p1, p2 = $p2")
}
/*
p1 = , p2 =
p1 = , p2 =
 */