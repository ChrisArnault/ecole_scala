package com.lateralThoughts.training.scala.beginners.solutions.exercise02

class VeryImportantPerson(override val name:String, private[this] var gender:String, private val birthYear:Int) extends Person(name, gender, birthYear) {

  override def isOlder(anotherPerson:Person) = false

  override def getGender = super.getGender


}
