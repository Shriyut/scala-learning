package org.getting_started.basics

object HelloWorldv2 extends App {
  println("Hello world from App trait")
}



object HelloYou extends App {
  if (args.length == 0)
    println("Hello, you")
  else
    println("Hello, " + args(0))
}