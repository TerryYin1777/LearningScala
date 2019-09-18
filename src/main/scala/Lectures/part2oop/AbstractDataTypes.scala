package Lectures.part2oop

object AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat = println("crunch crunch")
  }

  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal:String = "meat"
  }
  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = "nomnomnom"
    def eat(animal: Animal) = println(s"I'm a croc, and I'm eating ${animal.creatureType}")
  }


  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)
}
