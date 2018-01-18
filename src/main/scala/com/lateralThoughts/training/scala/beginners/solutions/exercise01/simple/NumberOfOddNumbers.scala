package com.lateralThoughts.training.scala.beginners.solutions.exercise01.simple

object NumberOfOddNumbers extends App {

  val elements = List(1,2,3,4,5)

  def numberOfOddsNumber(input:List[Int], number:Int):Int = input match {
    case Nil => number
    case x::xs if x % 2 == 1 => numberOfOddsNumber(xs, number + 1)
    case x::xs => numberOfOddsNumber(xs, number)
  }

  println("il y a " + numberOfOddsNumber(elements, 0) + " nombres impairs dans " + elements)

}
