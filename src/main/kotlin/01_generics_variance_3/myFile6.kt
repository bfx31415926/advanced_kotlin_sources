package f_01_generics_variance_3.myFile6

sealed class Response<R, E>
class Success<R, E>(val value: R) : Response<R, E>()
class Failure<R, E>(val error: E) : Response<R, E>()

fun main() {
    val rs1 = Success<Int, Nothing>(1)
    val rs2 = Success<String, Nothing>("ABC")
    val re1 = Failure<Nothing,Error>( Error() )
    val re2 = Failure<Nothing,String>( "Error" ) // Compilation error

//    val rs11 = Success(1) // Compilation error
//    val rs22 = Success("ABC") // Compilation error
//    val re11 = Failure(Error()) // Compilation error
//    val re22 = Failure("Error") // Compilation error
}