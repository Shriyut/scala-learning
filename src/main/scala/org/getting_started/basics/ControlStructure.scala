package org.getting_started.basics

object ControlStructure extends App {

  //if construct in scala always returns a result
  var a = 1
  var b = 3

  ////////////////////////////////////
  //if block
  ////////////////////////////////////

  private val minValue = if (a < b) a else b
//  if (test1) {
//    doX()
//  } else if (test2) {
//    doY()
//  } else {
//    doZ()
//  }

  println(minValue)
  // when every expression written returns a value, that style is referred as
  // expression-oriented programming (EOP)
  // lines of code that don't return any values are called statements
  // statements are used for their side-effects
  // if (a == b) doSomething()
  // this example runs the doSomething method as a side-effect when a is equal to b


  ////////////////////////////////////
  //for loops
  ////////////////////////////////////

  val nums = Seq(1,2,3)
  for (n <- nums) println(n)

  val people = List(
    "shriyut",
    "arijit",
    "satvik",
    "abhishek",
    "harshil",
    "utkarsh"
  )

  people.foreach(println)
  //foreach is available on most collections classes, including sequences, maps, and sets.

  val ratings = Map(
    "Oldboy" -> 5.0,
    "A Clockwerk Orange" -> 4.0,
    "Toofan" -> 0.5
  )
  for((name,rating) <- ratings) println(s"$name has rating $rating")

  ratings.foreach {
    case(movie, rating) => println(s"key: $movie, value: $rating")
  }

  // yield basically says to scala compiler
  // I want to yield a new collection from the existing collection that I'm iterating
  // over in the for-expression using the algorithm shown
  val doubledNums = for (n <- nums) yield n * 2
  val ucNames = for (name <- people) yield name.capitalize

  val editedNames = for (name <- people) yield {
    val nameWithoutFirstLetter = name.drop(1)
    val cap = nameWithoutFirstLetter.capitalize
  }
  //above block of code can be made smaller
  val capNames = for (name <- people) yield name.drop(1).capitalize
  val capNames1 = for (name <- people) yield { name.drop(1).capitalize }

  // while for-loop is used for side effects (such as printing output)
  // a for-expression is used to create new collections from existing collections

  ////////////////////////////////////
  //Match Expression
  ////////////////////////////////////

  val i = 4
  i match {
    case 1 => println("January")
    case 2 => println("February")
    //default value
    case _ => println("Invalid input")
  }

  //match expression also returns value, example below
  var month = i match {
    case 1 => "January"
    case 2 => "February"
    //default value
    case _ => "Invalid input"
  }
  println(month)

  //Match expression as a body of a method

  def convertBoolToString(bool: Boolean): String = bool match {
    case true => "true"
    case false => "false"
  }

  def isTrue(a: Any) = a match {
    case 0 | "" => false //if 0 or empty string evaluate as false
    case _ => true
  }

  val cmd = "x"
  cmd match {
    case "start" | "go" => println("starting")
    case "stop" | "quit" | "exit" => println("stopping")
    case _ => println("doing nothing")
  }

  val count = 0
  count match {
    case 1 => println("one, a lonely number")
    case x if (x == 2 || x == 3) => println("two's company, three's a crowd")
    case x if (x > 3) => println("4+, that's a party")
    case _ => println("i'm guessing your number is zero or less")
  }
  //code segments on the right side of -> can be written in multiple lines

  //scala uses java.io.* to work with files

  ////////////////////////////////////
  //Exception Handling
  ////////////////////////////////////


//  try {
//    // your scala code here
//  }
//  catch
//  {
//    case foo: FooException => handleFooException(foo)
//    case bar: BarException => handleBarException(bar)
//    case _: Throwable => println("Got some other kind of Throwable exception")
//  }
//  finally
//  {
//    // your scala code here, such as closing a database connection
//    // or file handle
//  }
}
