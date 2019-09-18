package Lectures.part2oop

object Exceptions extends App {

  val x: String = null
//  println(x.length)

  // 1. throwing exceptions
//  val aWeirdValue: String = throw new NullPointerException

  //throwable classes extend the Throwable class
  //Exception and Error are the major Throwable subtypes

  // 2. catching exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    getInt(false)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // code that will get executed no matter what
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException




  // Exercises

  // out of memory exception
//  val array = Array.ofDim(Int.MaxValue)

  // stack over flow exception
//  def sof(x:Int, s:String):String =
//    if (x == 0) s
//    else s + sof(x,s)
//
//  println(sof(2,"loop"))


  // PocketCalculator
  class OverFlowException extends Exception
  class UnderFlowException extends Exception
  class MathCalculationException extends Exception

  object PocketCalculator {

    def add(a:Int, b:Int): Int = {
      val result: Int = a + b
      if (a > 0 && b > 0 && result < 0) throw new OverFlowException
      else if (a < 0 && b < 0 && result > 0) throw new UnderFlowException
      else result
    }

    def subtract (a:Int, b:Int): Int = {
      val result: Int = a - b
      if (a > 0 && b < 0 && result < 0) throw new OverFlowException
      else if (a < 0 && b > 0 && result > 0) throw new UnderFlowException
      else result
    }

    def multiply (a:Int, b:Int): Int = {
      val result = a * b
      if (a > 0 && b > 0 && result < 0) throw new OverFlowException
      else if (a < 0 && b < 0 && result < 0) throw new OverFlowException
      else if (a > 0 && b < 0 && result > 0) throw new UnderFlowException
      else if (a < 0 && b > 0 && result > 0) throw new UnderFlowException
      else result
    }

    def divide (a:Int, b:Int): Double =
      if (b == 0) throw new MathCalculationException
      else a / b
  }


  println(PocketCalculator.add(1,2))
//  println(pc.add(2147483647,2))
//  println(Int.MaxValue)
  println(PocketCalculator.multiply(3,4))
  println(PocketCalculator.divide(5,2))
  println(PocketCalculator.divide(4,0))

}
