package Lectures.part1basics

import scala.annotation.tailrec

object Resursion extends App{
  def factorial(n:Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need the factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }

  println(factorial(5))

  def factorial2(n:Int): BigInt = {
    @tailrec
    def helper(pointer:Int, acc:BigInt): BigInt = {
      if (pointer <= 1) acc
      else helper(pointer - 1, pointer * acc)
    }

    helper(n,1)
  }

  //println(factorial2(5000))


  //Excercise

  def concatStrings(s: String, n: Int, board: String): String = {
    if (n <= 0) board
    else concatStrings(s, n - 1, s + board)
  }

  println(concatStrings("bitch",12,""))

  def isPrime(n:Int): Boolean = {
    @tailrec
    def canDivide(factor:Int, stillPrime:Boolean): Boolean = {
      if (!stillPrime) false
      else if (factor * factor > n) true
      else canDivide(factor + 1, n % factor != 0)
    }
    canDivide(2, true)
  }

  println(isPrime(5))
  println(isPrime(2003))
  println(isPrime(2003*29))


  def fib(n:Int): Int = {
    @tailrec
    def helper(p:Int, acc1:Int, acc2:Int): Int = {
      if (p >= n) acc1 + acc2
      else helper(p + 1, acc2, acc1 + acc2)
    }
    if (n <= 2) 1
    else helper(3,1,1)
  }

  println(fib(8))
}
