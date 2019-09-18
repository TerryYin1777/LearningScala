package Lectures.part2oop

object Objects {
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    //factory method
    def apply(mother:Person, father:Person): Person = new Person("Bobby")
  }

  class Person(val name:String) {

  }

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    val mary = new Person("Mary")
    val john = new Person("John")

    println(mary == john)

    val p1 = Person
    val p2 = Person
    println(p1 == p2)

    val bobby = Person(mary,john)
  }
//  println(Person.N_EYES)
//  println(Person.canFly)
//
//  val mary = new Person("Mary")
//  val john = new Person("John")
//
//  println(mary == john)
//
//  val p1 = Person
//  val p2 = Person
//  println(p1 == p2)
//
//  val bobby = Person(mary,john)
}
