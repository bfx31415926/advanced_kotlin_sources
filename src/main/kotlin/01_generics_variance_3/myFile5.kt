package f_01_generics_variance_3.myFile5

fun main(){
    val mlInts = mutableListOf<Int>(1,2,3)
//    val mlAny: MutableList<Any?> = mlInts //ошибка компиляции
                          // (из-за инвариантности MutableList)
}
