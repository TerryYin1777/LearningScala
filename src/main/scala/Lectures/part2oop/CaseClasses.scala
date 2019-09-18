package Lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim.toString)
  println(jim)
  //println(instance) = println(instance.toString)

  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim",34)
  println(jim2 == jim)
  println(jim2.equals(jim))

  // 4. case classes have handy copy methods
  val jim3 = jim.copy()
  println(jim3)
  val jim33 = jim.copy(age = 45)
  println(jim33)

  // 5. case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. case classes are serializable
  // akka

  // 7. case classes have extractor patterns = can be used in pattern matching

  case object UnitedKingdom {
    def name: String = "The Uk of GB and NI"
  }
}
