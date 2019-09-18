package Lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    def add[B >: A](element:B):MyList[B] = ???
  }
  class MyMap[Key, Value]
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //Does list of Cat extends the List of Animal?
  // 1. yes covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog)? the animalList will turn into a list of Animal. So need to be careful when defining
//  class MyList[+A] {
//    def add[B >: A](element:B):MyList[B] = ???
//  }

  // 2. no invariance
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. hell no. countravariant
  class Trainer[-A]
  val contraVariantList: Trainer[Cat] = new Trainer[Animal]


  //Bounded Types
  class Cage[A <: Animal] (animal: A)
  val cage = new Cage(new Dog)
  // A must be a subtype of Animal

  class Cage2[A >: Animal] (animal: A)
  val cage2 = new Cage(new Dog)
  // A must be a supertype of Animal
}
