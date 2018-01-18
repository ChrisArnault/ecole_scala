package com.lateralThoughts.training.scala.beginners

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._

object ExampleWithFutures extends App {

  val start = System.currentTimeMillis()

  val future1 = Future { Thread.sleep(10000); 1}
  val future2 = Future { Thread.sleep(10000); "Finished"}

  val future3 = for {
    x <- future1
    y <- future2
  } yield println("Le résultat est " + (x,y))

  //val future3 = future1.flatMap(x => future2.map(y => println("Le résultat est " + (x,y))))

  Await.result(future3, 3 seconds)

  val end = System.currentTimeMillis()

  println("Le programme a mis " + (end-start)/1000 + " secondes")

}
