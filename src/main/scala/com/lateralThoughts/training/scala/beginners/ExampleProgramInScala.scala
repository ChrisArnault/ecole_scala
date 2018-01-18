package com.lateralThoughts.training.scala.beginners

object ExampleProgramInScala extends App {

  val computator = new Computator(1,2)
  println("sum of 1 + 2 :" + computator.compute())

  val aList = 0::List(1,2,3)
  println("A sum of list : " + aList.map(_ + 1).foldRight(0)((x, y) => x + y))

}

class Computator(x:Int, y:Int) {

  def compute() = x + y

}
