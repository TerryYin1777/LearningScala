package Exercises

abstract class MyList[+A] {
  def isEmpty: Boolean
  def head: A
  def tail: MyList[A]
  def add[B >: A](elem: B): MyList[B]

  def filter(myPredicate: MyPredicate[A]): MyList[A]
  def map[B](myTransform: MyTransform[A,B]): MyList[B]
  def flatMap[B](myTransform: MyTransform[A,MyList[B]]): MyList[B]
  def ++[B >: A](list: MyList[B]): MyList[B]

  def printElement: String
  override def toString:String = "[" + printElement + "]"
//  def toString: String
}

case object Empty extends MyList[Nothing] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def add[B >: Nothing](elem: B):MyList[B] = new Cons(elem, Empty)

  def filter(myPredicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  def map[B](myTransform: MyTransform[Nothing,B]): MyList[B] = Empty
  def flatMap[B](myTransform: MyTransform[Nothing,MyList[B]]): MyList[B] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  def printElement: String = ""
}

case class Cons[+A](h:A, t: MyList[A]) extends MyList[A] {
  def isEmpty: Boolean = false
  def head: A = h
  def tail: MyList[A] = t
  def add[B >: A](elem: B): MyList[B] = new Cons(elem, this)

  def filter(myPredicate: MyPredicate[A]): MyList[A] = {
    if (myPredicate.test(h)) new Cons(h, t.filter(myPredicate))
    else t.filter(myPredicate)
  }

  def map[B](myTransform: MyTransform[A,B]): MyList[B] = {
    new Cons(myTransform.transform(h), t.map(myTransform))
  }

  def flatMap[B](myTransform: MyTransform[A,MyList[B]]): MyList[B] = {
    myTransform.transform(h) ++ t.flatMap(myTransform)
  }
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def printElement: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElement
}

trait MyPredicate[-T] {
  def test(item: T): Boolean
}

trait MyTransform[-A, B] {
  def transform(item: A): B
}







object ListTest extends App {
  val list = new Cons("a", new Cons(0, new Cons("d", new Cons(5, Empty))))
  println(list.tail.tail.head)
  println(list.add("7").head)
  println(list.isEmpty)

  println(list.toString)

  val list2 = new Cons(2, new Cons(-1, new Cons(3, new Cons(5, Empty))))
  println(list2.filter(new MyPredicate[Int] {
    def test(item: Int): Boolean = item > 0
  }))
  println(list2.map(new MyTransform[Int, Int] {
    def transform(item: Int): Int = item * 2
  }))

  println(list2.flatMap(new MyTransform[Int,MyList[Int]] {
    def transform(item: Int): MyList[Int] = new Cons(item, new Cons(item + 1,Empty))
  }))

  val cloneList2 = list2.copy()
  println(list2 == cloneList2)
}