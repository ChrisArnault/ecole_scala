package com.lateralThoughts.training.scala.beginners.exercise05

import scala.collection.immutable
import scala.collection.immutable.IndexedSeq

object ForComprehension extends App {
  
  val firstExample = (1 to 10).map(x => x*2)

  val secondExample: IndexedSeq[Int] = (1 to 10).flatMap(x => (10 to 1 by -1).map(y => x + y))

  val thirdExample: IndexedSeq[Int] = (1 to 10).filter(x => x % 3 == 0).map(x => x*x)

  val fourthExample = for {
    x <- 1 to 100
  } yield x/2

  val fifthExample = for {
    x <- 1 to 100
    if x < 50
  } yield x+50

  val sixthExample: Seq[(Int, Int, Int)] = for {
    x <- 1 to 50
    y <- x to 50
    if Math.sqrt(x*x + y*y).isValidInt
  } yield (x, y, Math.sqrt(x*x + y*y).toInt)

  val res = (1 to 50).flatMap { x =>
    (x to 50).filter { y => Math.sqrt(x*x + y*y).isValidInt}
      .map { y =>
        (x, y, Math.sqrt(x*x + y*y).toInt)
    }
  }

  println(res)
  println(sixthExample)

}
