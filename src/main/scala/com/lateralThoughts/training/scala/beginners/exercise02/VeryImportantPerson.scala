package com.lateralThoughts.training.scala.beginners.exercise02

class VeryImportantPerson(name: String,
                          private[this] var gender: String,
                          private val birthYear: Int)
  extends Person(name, gender, birthYear) {

  override def isOlder(toto: Person): Boolean = false

  override def getGender(): String = super.getGender()
}
