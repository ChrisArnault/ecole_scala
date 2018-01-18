package com.lateralThoughts.training.scala.beginners.solutions.exercise01.compulsory

import scala.io.StdIn.readInt
import scala.util.Random

object GuessTheNumber extends App {

  val numberToGuess = Random.nextInt(100) + 1

  def guess(acc: Int): Int = readInt() match {
    case x if x == numberToGuess => acc
    case x if x > numberToGuess => println("C'est moins"); guess(acc + 1)
    case _ => println("C'est plus"); guess(acc + 1)
  }

  println("Trouver le nombre entre 1 et 100")
  println("Bravo, vous avez trouvé en " + guess(1) + " coups")


}
