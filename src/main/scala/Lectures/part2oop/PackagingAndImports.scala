package Lectures.part2oop
import Playground.{Mike => Princess, PrinceCharming}

import java.util.{Date => utilDate}
import java.sql.{Date => sqlDate}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Terry","Pie", 2019)

  //import the package
  val mike = new Princess // Playground.Mike = fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LOGHT)

  // imports
  val prince = new PrinceCharming

  //use fully qualified names
  val date = new utilDate()
  val sqlDate = new sqlDate(1990)
  //use aliasing

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing , Function
  //scala.predef =println, ...
}
