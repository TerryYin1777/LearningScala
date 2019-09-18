package Lectures.part1basics

object Functions extends App {

  def aFunction(a:String, b:Int) = {
    a + " " + b
  }

  println(aFunction("hello",3))

  def aParameterlessFunction():Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString:String, n: Int):String = {
    if (n == 1) aString
    else aString + " " + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello",3))

  def aFunctionWithSideEffects(aString:String):Unit = println(aString)

  def aBigFunction(n:Int):Int = {
    def aSmallerFunction(a:Int, b:Int): Int = a + b

    aSmallerFunction(n, n-1)
  }






  //Exercises

  def greeting(name:String, age:Int): String = {
    "Hi, my name is " + name + ", and I'm " + age + " years old."
  }

  println(greeting("Terry", 28))

  def factorial(n:Int): Int = {
    if (n == 1) 1
    else n * factorial(n - 1)
  }

  println(factorial(5))

  def fib(n: Int): Int = {
    if (n == 1) 1
    else if (n == 2) 1
    else fib(n - 1) + fib(n - 2)
  }

  println(fib(9))

  def isPrime(n: Int): Boolean = {
    def canDivide(factor:Int): Boolean = {
      if (factor * factor > n) true
      else n % factor != 0 && canDivide(factor + 1)
    }
    canDivide(2)
  }

  println(isPrime(24))
}
