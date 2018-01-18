package com.lateralThoughts.training.scala.beginners.solutions.exercise05

import scala.collection.immutable.IndexedSeq

object ForComprehension extends App {

  val firstExample = (1 to 10).map(x => x*2)
  val firstConversion = for {
    x <- 1 to 10
  } yield x*2

  println(firstExample == firstConversion)

  val secondExample: IndexedSeq[Int] = (1 to 10).flatMap(x => (10 to 1 by -1).map(y => x + y))
  val secondConversion = for {
    x <- 1 to 10
    y <- 10 to 1 by -1
  } yield x + y
  println(secondExample == secondConversion)

  val thirdExample: IndexedSeq[Int] = (1 to 10).filter(x => x % 3 == 0).map(x => x*x)
  val thirdConversion = for {
    x <- 1 to 10
    if x % 3 == 0
  } yield x*x
  println(thirdExample == thirdConversion)

  val fourthExample = for {
    x <- 1 to 100
  } yield x/2
  val fourthConversion = (1 to 100).map(x => x/2)
  println(fourthExample == fourthConversion)

  val fifthExample = for {
    x <- 1 to 100
    if x < 50
  } yield x+50
  val fifthConversion = (1 to 100).filter(x => x < 50).map(x => x + 50)
  println(fifthExample == fifthConversion)

  val sixthExample = for {
    x <- 1 to 50
    y <- x to 50
    if Math.sqrt(x*x + y*y).isValidInt
  } yield (x, y, Math.sqrt(x*x + y*y).toInt)
  val sixthConversion = (1 to 50)
    .flatMap(x => (x to 50)
      .filter(y => Math.sqrt(x*x + y*y).isValidInt)
      .map(y => (x, y, Math.sqrt(x*x + y*y).toInt)))
  println(sixthExample == sixthConversion)


}
