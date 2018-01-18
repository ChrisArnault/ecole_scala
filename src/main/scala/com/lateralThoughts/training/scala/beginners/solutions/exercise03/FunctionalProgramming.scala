package com.lateralThoughts.training.scala.beginners.solutions.exercise03

object FunctionalProgramming extends App {

  def factorial(n: Int) = {
    def innerFactorial(x: Int, acc: Int): Int = x match {
      case 0 => acc
      case a => innerFactorial(a - 1, acc * a)
    }
    innerFactorial(n, 1)
  }

  def reverse[A](aList: List[A]): List[A] = {
    def innerReverse(treated: List[A], acc: List[A]): List[A] = treated match {
      case Nil => acc
      case x :: xs => innerReverse(xs, x :: acc)
    }
    innerReverse(aList, Nil)
  }

  def map[A, B](aList: List[A], f: A => B): List[B] = aList match {
    case Nil => Nil
    case x::xs => f(x)::map(xs, f)
  }

  def filter[A](aList: List[A], f: A => Boolean): List[A] = aList match {
    case Nil => Nil
    case x::xs if f(x) => x::filter(xs, f)
    case x::xs => filter(xs, f)
  }

  println("La factorielle de 7 est " + factorial(7))
  println("L'inverse de la liste List(1, 2, 3) est " + reverse(List(1, 2, 3)))
  println("Multiplier tous les éléments de la liste List(1, 2, 3) par deux donne " + map[Int, Int](List(1,2,3), x => x*2))
  println("Filtrer la liste List(1, 2, 3, 4, 1, 5 en ne gardant que les éléments strictement supérieurs à deux donne " + filter[Int](List(1, 2, 3, 4, 1, 5), _ > 2))

}
