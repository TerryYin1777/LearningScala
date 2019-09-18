package Lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  //anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat:Unit = println("hahahahah")
  }
  /*
    step 1:
    class Lectures.part2oop.AnonymousClasses$$anon$1 extends Animal {
      override def eat:Unit = println("hahahahah")
    }

    step 2:
    val funnyAnimal = new Lectures.part2oop.AnonymousClasses$$anon$1
   */
  println(funnyAnimal.getClass)

  class Person(name:String) {
    def sayHi:String = s"Hi, my name is $name, how can I help you"
  }

  val jim = new Person("Jim") {
    override def sayHi: String = s"Hi, my name is Jim, how can I save your ass"
  }

  println(jim.sayHi)
}
