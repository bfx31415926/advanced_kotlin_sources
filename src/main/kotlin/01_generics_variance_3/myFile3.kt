package f_01_generics_variance_3.myFile3

open class A
class B: A()

class Box<T>        //инвариантность
class BoxIn<in T>   //контрвариантность
class BoxOut<out T> //ковариантность


fun main(){
    //инвариантность
    var boxA: Box<A> = Box<A>()
    var boxB: Box<B> = Box<B>()
    //boxA = boxB //Compile error
    //boxB = boxA //Compile error

    //контрвариантность
    var boxAIn: BoxIn<A> = BoxIn<A>()
    var boxBIn: BoxIn<B> = BoxIn<B>()
    boxBIn = boxAIn
    boxAIn = boxBIn //Compile error (если закомментить предыдущую строку)

    //ковариантность
    var boxAOut: BoxOut<A> = BoxOut<A>()
    var boxBOut: BoxOut<B> = BoxOut<B>()
    boxAOut = boxBOut
    boxBOut = boxAOut //Compile error (если закомментить предыдущую строку)
}
