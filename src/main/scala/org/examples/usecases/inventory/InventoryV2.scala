package org.examples.usecases.inventory

import scala.collection.mutable.Map
import scala.io.StdIn.readLine
import scala.sys.exit

//productId -> Quantity
var inventoryMap: Map[Int, Int] = Map(
  1 -> 25, 2 -> 10, 3 -> 50, 4 -> 3, 5 -> 7
)

var productList: List[Products] = List(
  Products(1, "Football", "Football", 750.00),
  Products(2, "Tennis Racquet", "Tennis", 5000.00),
  Products(3, "Shin guard", "Football", 1000.00),
  Products(4, "Football Boot", "Football", 800.00),
  Products(5, "Cricket Boot", "Cricket", 500.00)
)

case class Products(productId: Int, name: String, category: String, price: Double)

case class Inventory(productId: Int, quantity: Int) {
  def updateInventory(): Unit = {
    inventoryMap(productId) = quantity
  }
}

object Execute extends App {

  def execute(fn: () => Unit): Unit = fn()

  def addProducts() = {

    println("Enter product Id")
    val productId = readLine()
    println("Enter product name")
    val productName = readLine()
    println("Enter product category")
    val productCategory = readLine()
    println("Enter product price")
    val productPrice = readLine()

    val newProduct = Products(productId.toInt, productName, productCategory, productPrice.toDouble)
    productList = productList :+ newProduct
  }

  def changeInventory() = {

    println("Enter productId")
    val productId = readLine().toInt
    var newQuantity = 0
    val oldQuantity = inventoryMap(productId)
    println("Enter action, either add or delete")
    val action = readLine().toLowerCase
    println("Enter quantity")
    val quantity = readLine().toInt
    if (action == "add") {
      newQuantity = oldQuantity + quantity
    } else if (action == "delete") {
      newQuantity = oldQuantity - quantity
    }else {
      println(s"$action is not a valid operation, please re-trigger")
      exit(-1)
    }
    val item = Inventory(productId, newQuantity)
    item.updateInventory()
  }

  def getItems() = {

    println("Enter product id ")
    val productId = readLine().toInt
    val quantity = inventoryMap(productId)
    val productName = productList.filter(_._1 == productId).map(_._2).head
    println(s"$productName has $quantity units")

  }

  def gracefulTermination() = {
    println("You didn't provide a valid input")
    exit(0)
  }


  println(" Press 1 to add product \n Press 2 to update inventory \n Press 3 to get inventory details")
  val taskId = readLine()

  taskId match {
    case "1" => execute(addProducts)
    case "2" => execute(changeInventory)
    case "3" => execute(getItems)
    case _ => execute(gracefulTermination)
  }

  println(productList)
  println(inventoryMap)
  //TODO: Maintain state using recursion for an executed instance of the object
  //TODO: Play around with case classes and observe their behaviour
}
