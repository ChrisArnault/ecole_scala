package com.lateralThoughts.training.scala.beginners.solutions.exercise01.advanced

// Afficher les nombres premiers entre 1 et 100
object Eratosthene extends App {

  def filter(i:Int, aList:List[Int]):List[Int] = aList match {
    case Nil => Nil
    case x::xs if x % i == 0 => filter(i, xs)
    case x::xs => x::filter(i, xs)
  }

  val aList:List[Int] = (2 to 100).toList

  def eratosthene(treated:List[Int]):List[Int] = treated match {
    case Nil => Nil
    case x::xs => x::eratosthene(filter(x, xs))
  }

  println("Les nombres premiers entre 1 et 100 sont " + eratosthene(aList))

}

