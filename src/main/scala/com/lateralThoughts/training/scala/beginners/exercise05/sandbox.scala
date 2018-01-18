package com.lateralThoughts.training.scala.beginners.exercise05

import java.time.LocalDate

object MainSandbox {
  def main(args: Array[String]): Unit = {
    // TODO Conversion implicit de Person vers Int (via l'age)
    val ryan = Person("ryan", 14, LocalDate.now())
    isAdult(ryan)
    isAdultGeneric(ryan)
    ryan.isAdult
  }

  implicit def fromPersonToAge(person: Person): Int = person.age

  def isAdult(age: Int): Boolean = age > 18

  def isAdultGeneric[A](obj: A)(implicit converter: A => Int): Boolean = {
    converter(obj) > 18
  }

  implicit class PimpMyAdult[T <: Person](val person: T) extends AnyVal {
    def isAdult() = person.age > 18
  }









}