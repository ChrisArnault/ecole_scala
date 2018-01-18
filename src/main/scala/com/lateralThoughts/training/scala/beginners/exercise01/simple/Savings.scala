package com.lateralThoughts.training.scala.beginners.exercise01.simple

/**
  * Calculer le nombre d'années nécessaires pour atteindre une certaine somme en plaçant une somme de départ à un taux d'intérêt donné
  *
  * Par exemple, pour atteindre 200 euros en partant d'une somme initiale de 100 euros et d'un taux de 5 %, il faut
  * attendre 15 ans
  */
object Savings extends App {

  val initialSum = 100
  val interestRate = 0.1
  val finalSum = 200 * 10000000000000000L

  def compute(sum: Double, counter: Int): Int = {
    if (sum > finalSum) {
      counter
    } else {
      /*val result = compute(sum + sum * interestRate/ 100, counter + 1)
      println("yolo")
      result*/
      compute(sum + sum * interestRate/ 100, counter + 1)
    }
  }

  val counter = compute(initialSum, 0)

  /*
  var total = initialSum.toDouble
  var counter = 0
  while (total < finalSum) {
    counter += 1
    total += total * interestRate/100.0
  }*/
  println(s"Count : $counter")
}
