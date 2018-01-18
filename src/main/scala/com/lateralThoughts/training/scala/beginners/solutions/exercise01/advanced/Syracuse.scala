package com.lateralThoughts.training.scala.beginners.solutions.exercise01.advanced

object Syracuse extends App {

  def nextSyracuse(n: Int) = if (n % 2 == 0) n / 2 else 3 * n + 1

  def sequenceLength(n: Int) = {
    def innerSequenceLength(n: Int, acc: Int): Int = n match {
      case 1 => acc
      case a => innerSequenceLength(nextSyracuse(a), acc + 1)
    }
    innerSequenceLength(n, 1)
  }

  def longestSequence(i: Int, acc: (Int, Int)):(Int, Int) = i match {
    case 100 => acc
    case n =>
      val length = sequenceLength(n)
      if (length > acc._2) longestSequence(n+1, (n, length)) else longestSequence(n+1, acc)
  }
  
  val longest = longestSequence(1, (1, 1))
  println("La plus grande séquence de syracuse entre 1 et 99 est celle commençant par le nombre " + longest._1 + " et qui est longue de " + longest._2 + " itérations")

}
