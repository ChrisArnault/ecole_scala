package com.lateralThoughts.training.scala.beginners.exercise01.compulsory

import scala.util.Random

object GuessTheNumber extends App {
  import scala.io.StdIn._

  val numberToGuess = Random.nextInt(100)
  val name = readLine("Coucou ! C'est quoi ton p'tit nom mon chou ?")
  println(s"Salut $name ! Devines mon age :")
  var nok = true
  while (nok) {
    val guess = readInt()
    if (guess > numberToGuess) {
      println("C'est moins !")
    } else if (guess < numberToGuess) {
      println("C'est plus !")
    } else {
      println("Bravo !")
      nok = true
    }
  }
}
