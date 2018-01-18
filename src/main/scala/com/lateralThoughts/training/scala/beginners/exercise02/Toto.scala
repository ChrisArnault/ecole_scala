package com.lateralThoughts.training.scala.beginners.exercise02

sealed trait Animal
class Orignal extends Animal
class Chien extends Animal
class Kangourou extends Animal

case class Person2(name: String, age: Int, gender: Char)

object MainAnimal extends App {
  /*val animal: Animal = new Chien
  animal match {
    case chien: Chien =>
    case og: Orignal =>
    case k: Kangourou =>
  }*/

  val ryan = Person2("ryan gosling", 35, 'M')
  ryan match {
    case Person2(_, age, 'M') if age > 18 =>
      println(s"C'est un majeur de $age ans")
    case Person2(_, age, 'F') if age > 18 =>
      println(s"C'est une majeure de $age ans")
    case _ =>
      println("osef")
  }



  val toto: Seq[Long] = List(1, 1L)
}