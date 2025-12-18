package f_01_generics_variance_3.myPages37_38

fun takeIntList(list: List<Int>) {}

fun takeIntMutableList(list: MutableList<Int>) {}

fun takeAnyList(list: List<Any>) {}

class BoxOut<out T>

fun takeBoxOutInt(box: BoxOut<Int>) {}

fun takeBoxOutNumber(box: BoxOut<Number>) {}

fun takeBoxOutNothing(box: BoxOut<Nothing>) {}

fun takeBoxOutStar(box: BoxOut<*>) {}

class BoxIn<in T>

fun takeBoxInInt(box: BoxIn<Int>) {}

fun main() {
//    takeIntList(listOf<Any>()) //ошибка компиляции(список контрвариантен)
    takeIntList(listOf<Nothing>())

    //ошибка компиляции(MutableList инвариантен)
//    takeIntMutableList(mutableListOf<Any>())
//    takeIntMutableList(mutableListOf<Nothing>())

    takeAnyList(listOf<Int>())
    takeAnyList(listOf<Nothing>())

    takeBoxOutInt(BoxOut<Int>())
//    takeBoxOutInt(BoxOut<Number>())//ошибка компиляции(из-за ковариантности)
    takeBoxOutInt(BoxOut<Nothing>())

    takeBoxOutNumber(BoxOut<Int>())
    takeBoxOutNumber(BoxOut<Number>())
    takeBoxOutNumber(BoxOut<Nothing>())

//    takeBoxOutNothing(BoxOut<Int>()) //ошибка компиляции(из-за ковариантности)
//    takeBoxOutNothing(BoxOut<Number>()) //ошибка компиляции(из-за ковариантности)
    takeBoxOutNothing(BoxOut<Nothing>())

    takeBoxOutStar(BoxOut<Int>())
    takeBoxOutStar(BoxOut<Number>())
    takeBoxOutStar(BoxOut<Nothing>())

    takeBoxInInt(BoxIn<Int>())
    takeBoxInInt(BoxIn<Number>())
//    takeBoxInInt(BoxIn<Nothing>()) //ошибка компиляции(из-за контрвариантности)
    takeBoxInInt(BoxIn<Any>())
}