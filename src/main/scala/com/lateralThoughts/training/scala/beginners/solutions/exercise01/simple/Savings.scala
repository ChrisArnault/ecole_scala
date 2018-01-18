package com.lateralThoughts.training.scala.beginners.solutions.exercise01.simple

import scala.io.StdIn.readFloat

object Savings extends App {

  print("Quelle est la somme initialement placée ? ")
  val initialSum = readFloat()
  print("Quel est le taux ? ")
  val interestRate = readFloat()
  print("Quelle est la somme à atteindre ? ")
  val finalSum = readFloat()

  def computeInt(currentSaving:Float, years:Int):Int = currentSaving match {
    case x if x > finalSum => years
    case x => computeInt(currentSaving*(1+interestRate/100), years+1)
  }

  println("Il vous faut " + computeInt(initialSum, 0) + " années pour atteindre la somme de " + finalSum)

}
