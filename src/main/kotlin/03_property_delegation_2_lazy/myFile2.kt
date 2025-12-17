package f_03_property_delegation_2_lazy.myFile2

data class User(
    val name: String,
    val surname: String,
    val pronouns: Int,
    val gender: String,
// ...
) {
    val fullDisplay: String by lazy { produceFullDisplay()}

    fun produceFullDisplay(): String {
        print("Calculating...")
// ...
        return "XYZ"
    }
}

fun main() {
    val user = User("Alex", "Smirnov", 1, "M")
    val copy = user.copy()
    println(copy.fullDisplay) // Calculating... XYZ
    println(copy.fullDisplay) // XYZ
 }
/*
Calculating...XYZ
XYZ
 */