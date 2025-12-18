package f_03_property_delegation_3_observable.myPage89

import kotlin.properties.Delegates.observable

open class Presenter(val id: Int) {
    fun onCreate() =
        println("(${this::class.simpleName}) onCreate: (id = $id)")

    fun onDestroy() =
        println("(${this::class.simpleName}) onDestroy: (id = $id)")

    override fun toString() = "${this::class.simpleName}( $id )"
}

class Pres1(id: Int) : Presenter(id)

class Pres2(id: Int) : Presenter(id)

var presenters: List<Presenter> by
observable(emptyList()) { _, old, new ->
    (new - old).forEach { it.onCreate() }
    (old - new).forEach { it.onDestroy() }
}

fun main() {
    presenters = listOf(Pres1(1), Pres2(2))
    presenters -= presenters.last()
    presenters += Pres1(3)

    //Добавление пустого списка не вызовет onCreate / onDestroy
    presenters += emptyList<Presenter>()

    println(presenters)

    while (presenters.isNotEmpty()) {
        presenters -= presenters.last()
    }

    println(presenters)
}
/*
(Pres1) onCreate: (id = 1)
(Pres2) onCreate: (id = 2)
(Pres2) onDestroy: (id = 2)
(Pres1) onCreate: (id = 3)
[Pres1( 1 ), Pres1( 3 )]
(Pres1) onDestroy: (id = 3)
(Pres1) onDestroy: (id = 1)
[]
 */


