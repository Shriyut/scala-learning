package org.getting_started.basics

object Curry extends App {
  private def add(x: Int, y:Int):Int = {
    x+y
  }
  println(add(3,4))

  private def addCurry(x:Int)(y:Int)(z:Int) = {
    x+y+z
  }
  println(addCurry(1)(2)(3))

}
