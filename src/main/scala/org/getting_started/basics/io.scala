package org.getting_started.basics

import scala.io.StdIn.readLine

object io extends App {
  print("Enter your first name:")
  val firstName = readLine()

  print("Enter last name:")
  val lastName = readLine()

  println(s"Your name is $firstName $lastName")
}
