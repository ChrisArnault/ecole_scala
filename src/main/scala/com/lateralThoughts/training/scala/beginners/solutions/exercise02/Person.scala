package com.lateralThoughts.training.scala.beginners.solutions.exercise02

class Person(val name:String, private[this] var gender:String, private val birthYear:Int) {

  def isOlder(anotherPerson:Person) = birthYear > anotherPerson.birthYear

  protected[exercise02] def getGender = gender

}

object Person {

  def apply(name:String, gender:String, birthYear:Int) = new Person(name, gender, birthYear)
  
}

