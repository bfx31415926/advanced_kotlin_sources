package f_01_generics_variance_3.s_1

open class Dog
class Puppy : Dog()
open class Hound : Dog()

open class Other: Hound()
class Other1: Other()

class Box<in T> {
    private var value: T? = null
    
    fun put(value: T) {
        this.value = value
    }

    fun get() = value!!
}

fun main() {
    val dogBox = Box<Dog>()
    dogBox.put(Dog())
    println(dogBox.get())
    dogBox.put(Puppy())
    println(dogBox.get())
    dogBox.put(Hound())
    println(dogBox.get())

    val puppyBox: Box<Puppy> = dogBox
    puppyBox.put(Puppy())
    println(dogBox.get())

    val houndBox: Box<Hound> = dogBox
    houndBox.put(Hound())
    println(dogBox.get())

    val otherBox: Box<Other> = Box<Hound>()
    val otherBox1: Box<Other1> = Box<Other>()
}
