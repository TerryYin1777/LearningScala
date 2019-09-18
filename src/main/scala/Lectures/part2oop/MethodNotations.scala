package Lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie:String): Boolean = movie ==favouriteMovie
    def +(person: Person):String = s"${this.name} is hanging out with ${person.name}"
    def +(nickName: String): Person = new Person(s"$name ($nickName)", favouriteMovie)
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)

    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true

    def learns(skill: String): String = s"$name learns $skill"
    def learnScala: String = this learns "scala"

    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def apply(food:String): String = s"Hi, my name is $name and I like $food"
    def apply(n: Int): String = s"$name watched $favouriteMovie $n times"

  }

  val mary = new Person("Mary","Inception", 19)
  println(mary.likes("Inception"))
  println(mary likes "Inception")

  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(2 + 3)
  println(2.+(3))

  val x = -1
  val y = 1.unary_-
  println(x == y)

  println(!mary)
  println(mary.unary_!)

//  println(mary isAlive)
  println(mary.apply("burgers"))
  println(mary("burgers"))


  println((mary + "the rockstar")())

  val mary3 = +mary
  println(mary3.age)

  println(mary learnScala)
  println(mary(3))
}
