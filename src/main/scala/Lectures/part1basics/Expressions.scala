package Lectures.part1basics

object Expressions extends App{
  val x = 1 + 2
  println(x)
  println(2 + 3 * 4)
  println(1 == x)
  println(!(1 == x))

  var aVariable = 2
  aVariable += 3 // works with += -= *=...... side effects
  println(aVariable)

  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3

  println(aConditionValue)


  var i = 0
  val aWhile: Unit = while (i < 10) {
    println(i)
    i += 1
  }

  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)


  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }


}
