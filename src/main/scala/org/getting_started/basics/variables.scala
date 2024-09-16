val x = 0 //immutable
var y = 1 //mutable - value can be changed

//scala can infer type of data stored in variables - type inference
//devs can explicitly define the variable types as well

val s: String = "sample string"

/////////////////////////////
//defining a class variable//
/////////////////////////////
//val p: Person = new Persona("Rakesh")

val fruits = List("apple", "banana", "quava", "orange")

val nums1 = List.range(0, 10)
val nums2 = (1 to 10 by 2).toList
val letters1 = ('a' to 'f').toList
val letters2 = ('a' to 'f' by 2).toList

//Tuples can contain between 2 and 22 values, and they can all be different types

//val (num, string, person) = (11, "Eleven", new Person("Eleven"))


//Its not required to mention type of the variable in java
//val p = new Person("Candy") // preferred
//val p: Person = new Person("Candy") // unnecessarily verbose


val b: Byte = 1
val x1: Int = 1
val l: Long = 1
val s1: Short = 1
val d: Double = 2.0
val f: Float = 3.0

val i = 123 // defaults to Int
val x2 = 1.0 // defaults to Double

val firstName = "Shriyut"
val lastName = "Jha"

val name = s"$firstName $lastName"

//we can also put expressions inside string interpolation braces
//println(1+1 = ${1+1})

//multiline string
val speech =
  """
    | SAMPLE MULTILINE VARIABLE
    | SDASDASDSDSDASDA
    |""".stripMargin //WITHOUT STRIPMARGIN THE MULTI LINES TAKE INDENTATION FROM THE CODE