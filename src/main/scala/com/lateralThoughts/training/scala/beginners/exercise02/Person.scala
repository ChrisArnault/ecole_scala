package com.lateralThoughts.training.scala.beginners.exercise02

class Person(val name: String,
             private[this] var gender: String,
             private val birthYear: Int) {

  def this(name: String) = this(name, "M", 0)

  def isOlder(toto: Person): Boolean = toto.birthYear < birthYear

  private[scala] def getGender(): String = gender
}

object Person {
  type Name = String
  type Gender = String

  def apply(name: String, gender: String, birthYear: Int): Person = new Person(
    name, gender, birthYear
  )

  def apply(name: String): Person = new Person(
    name, "M", 0
  )
}

object Main {
  def main(args: Array[String]): Unit = {
    new Person("toto", "titi", 12)
    Person("toto", "titi", 12)
    Person("titi")
  }
}









