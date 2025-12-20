package f_09_reflection_3.s_5_1

import kotlin.math.ln
import kotlin.random.Random
import kotlin.reflect.KType
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.full.withNullability
import kotlin.reflect.typeOf

class RandomValueConfig(
    val nullProbability: Double = 0.1,
    val zeroProbability: Double = 0.1,
    val stringSizeParam: Double = 0.1,
    val listSizeParam: Double = 0.3,
)
class ValueGenerator(
    private val random: Random = Random,
    val config: RandomValueConfig = RandomValueConfig(),
) {
    inline fun <reified T> randomValue(): T =
        randomValue(typeOf<T>()) as T

    fun randomValue(type: KType): Any? = when {
        type.isMarkedNullable -> randomNullable(type)
        type == typeOf<Boolean>() -> randomNullable(type)
        type == typeOf<Int>() -> randomInt()
        type == typeOf<String>() -> randomString()
        type.isSubtypeOf(typeOf<List<*>>()) ->
            randomList(type)
        // ...
        else -> error("Type $type not supported")
    }

    private fun randomNullable(type: KType) =
        if (randomBoolean(config.nullProbability)) null
        else randomValue(type.withNullability(false))

    private fun randomString(): String =
        (1..random.exponential(config.stringSizeParam))
            .map { CHARACTERS.random(random) }
            .joinToString(separator = "")

    private fun randomList(type: KType) =
        List(random.exponential(config.listSizeParam)) {
            randomValue(type.arguments[0].type!!)
        }

    private fun randomInt() =
        if (randomBoolean(config.zeroProbability)) 0
        else random.nextInt()

    private fun randomBoolean() =
        random.nextBoolean()

    private fun randomBoolean(probability: Double) =
        random.nextDouble() < probability

    companion object {
        private val CHARACTERS =
            ('A'..'Z') + ('a'..'z') + ('0'..'9') + " "
    }
}

private fun Random.exponential(f: Double): Int {
    return (ln(1 - nextDouble()) / -f).toInt()
}

fun main() {
    val r = Random(1)
    val g = ValueGenerator(random = r)
    repeat(20){println(g.randomValue<List<Int?>?>())}
}
/*
[315684520, 1278830002, 1985022034, -1476882529, 2007653304, -790149034]
[-635476277, -875963796]
[230732034, null, 1685787794, -536786686, -366240659, -599275408, 1914221232]
null
[796487592, 1285964103, 417087274]
[-767209408, -981126421, null, 1288899021]
null
[]
[]
[]
[]
null
[]
[76864096]
[-2001011299, 445749829, -248088379, 579351217, 1467334995, 2130878562, 767537789]
null
[-462421044, 866326223, -929085983, 1021042036, -551068673, 0]
[-133889947, 1459961400, -956129028, null]
[]
null
 */