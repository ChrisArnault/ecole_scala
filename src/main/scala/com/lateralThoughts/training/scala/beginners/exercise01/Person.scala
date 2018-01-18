package com.lateralThoughts.training.scala.beginners.exercise01

class Person(val name: String,
             private[this] var gender: String,
             private val birthYear: Int) {

  def isOlder(toto: Person): Boolean = toto.birthYear < birthYear

  //def constraint(toto: Person): Boolean = toto.gender != gender

  private[scala] def getGender(): String = gender

  /*val stream = "()()(())".zipWithIndex.toIterator
  Iterator.apply(stream.head)
  val res = "()()(())".zipWithIndex.foldLeft(0) {
    case (accum, (char, position)) =>
      if (accum == -1)
        return position
      if (char == '(') {
        accum + 1
      } else {
        accum - 1
      }
  }*/

  val toto = getGender
}
