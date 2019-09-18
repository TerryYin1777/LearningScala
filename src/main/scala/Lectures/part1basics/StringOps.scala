package Lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ","-"))
  println(str.toLowerCase)
  println(str.length)

  val aNumberString = "45"

  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  val name = "Terry"
  val age = 16
  val greeting = s"Hello, my name is $name and I am $age years old"
  val greeting2 = s"Hello, my name is $name and I will be turning ${age + 1} years old "
  println(greeting)
  println(greeting2)

  val speed = 12.2f
  val myth = f"$name can eat $speed%3.3f burgers per minute"
  println(myth)

  println(raw"This is the \n newline")
}
