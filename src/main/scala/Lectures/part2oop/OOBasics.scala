package Lectures.part2oop

object OOBasics extends App {

//  val person = new Person("Terry", 18)
//  println(person.x)
//  person.greet
//  person.greet("Bitch")

  val writer1 = new Writer("Terry", "Yin", 1990)
  println(writer1.fullName)
  val writer2 = new Writer("Mother", "Fucker", 2000)

  val novel1 = new Novel("How to be a rich man",2017, writer1)
  println(novel1.authorAge())
  println(novel1.isWrittenBy(writer1))
  println(novel1.isWrittenBy(writer2))
  val novel2 = novel1.copy(2019)
  println(novel2.name)
  println(novel2.author.fullName())


  val counter = new Counter(5)
  println(counter.count)
  val counter1 = counter.increment()
  println(counter1.count)
  val counter2 = counter1.increment(3)
  println(counter2.count)
  val counter3 = counter2.decrement(4)
  println(counter3.count)
}

//class Person(name:String, val age:Int) {
//  val x = 2
//
//  println(1 + 3)
//
//  def greet(name:String): Unit = println(s"${this.name} says: Hi, $name")
//
//  def greet(): Unit = println(s"Hi, I'm $name")
//
//  def this(name: String) = this(name,0)
//}

//Exercise

class Writer(firstName: String, surName: String, val yearOfBirth: Int) {

  def fullName(): String = firstName + " " + surName

}

class Novel(val name: String, yearOfRelease: Int, val author: Writer) {

  def authorAge(): Int = yearOfRelease - author.yearOfBirth
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}


class Counter(val count: Int = 0) {

  def increment(): Counter = {
    println("Incrementing")
    new Counter(count + 1)
  }

  def decrement(): Counter = {
    println("decrementing")
    new Counter(count - 1)
  }

  def increment(amount: Int): Counter = {
    if (amount <= 0) this
    else this.increment().increment(amount - 1)
  }

  def decrement(amount: Int): Counter = {
    if (amount <= 0) this
    else this.decrement().decrement(amount - 1)
  }
}
