package my_experiments.myRandom1

import kotlin.random.Random

val CHARACTERS = ('A'..'Z') + ('a'..'z') + ('0'..'9') + " "

fun randomString(random: Random): String =
    (1..10).map { CHARACTERS.random(random) }
        .joinToString(separator = "")

fun main() {
    var random = Random(1)
    repeat(20){println(randomString(random))}
}
/*
VVf28RcnsS
Z3ndrbxvIC
FczHTVqNYf
HcI8lRCi8H
C4gCETraDp
1l6z86n9K1
WjMNxTwDPr
QedI27kVAg
5Y7ABnHBlE
AIKeGp9Q7T
jHe1dqARHj
Ujee3i6XZz
hQ02lTIelD
lGw2aVZNg1
Jjd4RdAq0C
efwqV1aMg8
Gt3jBX69oR
uQDj8GGoDs
AQhPPDh0fB
vHnOqZLvJn
 */
