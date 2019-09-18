package Lectures.part1basics

object CBNvsCNV extends App {

  def callByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }


  def callByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(),34)
  printFirst(34,infinite())
}
