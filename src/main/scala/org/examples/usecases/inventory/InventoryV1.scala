package org.examples.usecases.inventory

import scala.io.StdIn.readLine
import scala.collection.mutable.Map
import scala.sys.exit

//case class Inventory(productId: Int, quantity: Int)
//case class Products(productId: Int, name: String, category: String, price:Double)

object Main extends App {

  //need to integrate the logic with case classes & add exception handling - not a complete solution as per the usecase

//  val inventory = List(Inventory(1, 25), Inventory(2, 10), Inventory(3, 50),
//                        Inventory(4, 3), Inventory(5, 7))
//
//  val products = List(
//    Products(1, "Football", "Football", 750.00),
//    Products(2, "Tennis Racquet", "Tennis", 5000.00),
//    Products(3, "Shin guards", "Football", 1000.00),
//    Products(4, "Football Boots", "Football", 800.00),
//    Products(5, "Cricket Boots", "Cricket", 500.00)
//  )

  //productId -> quantity
  var inventoryMap: Map[Int, Int] = Map(
    1 -> 25, 2 -> 10, 3 -> 50, 4 -> 3, 5 -> 7
  )

  var products = List(
    (1, "Football", "Football", 750.00),
    (2, "Tennis Racquet", "Tennis", 5000.00),
    (3, "Shin guard", "Football", 1000.00),
    (4, "Football Boot", "Football", 800.00),
    (5, "Cricket Boot", "Cricket", 500.00)
  )

  var productIdList = products.map(_._1)

  def addProducts(): Unit = {
    println("Enter product Id")
    val productId = readLine()
    println("Enter product name")
    val productName = readLine()
    println("Enter product category")
    val productCategory = readLine()
    println("Enter product price")
    val productPrice = readLine()

    val newProduct = (productId.toInt, productName, productCategory, productPrice.toDouble)
    products = products :+ newProduct
    println(products)
  }

  def updateInventory(): Unit = {

    println("Enter productId")
    val productId = readLine().toInt
    println("Enter action, either add or delete")
    val action = readLine().toLowerCase
    println("Enter quantity")
    val quantity = readLine().toInt
    if (action == "add") {
      inventoryMap(productId) = inventoryMap(productId) + quantity
    } else if (action == "delete") {
      inventoryMap(productId) = inventoryMap(productId) - quantity
    }else {
      println(s"$action is not a valid operation, please re-trigger")
      exit(-1)
    }

    println(inventoryMap)
  }

  def listItems(): Unit = {
    println("Enter product id ")
    val productId = readLine().toInt
    val quantity = inventoryMap(productId)
    val productName = products.filter(_._1 == productId).map(_._2).head
    println(s"$productName has $quantity units")

  }

  def execute(fn: () => Unit): Unit = fn()

  println(" Press 1 to add product \n Press 2 to update inventory \n Press 3 to get inventory details")
  var taskId = readLine()

  taskId match {
    case "1" => execute(addProducts)
    case "2" => execute(updateInventory)
    case "3" => execute(listItems)
    case _ => println("Please provide a valid input operation")
  }

}
