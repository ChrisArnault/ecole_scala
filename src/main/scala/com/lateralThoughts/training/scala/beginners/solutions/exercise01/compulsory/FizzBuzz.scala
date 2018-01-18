package com.lateralThoughts.training.scala.beginners.solutions.exercise01.compulsory

object FizzBuzz extends App {

  def fizzBuzz(i: Int): Unit = i match {
    case 100 =>
    case a if (a % 3 == 0) && (a % 5 == 0) => println("FizzBuzz"); fizzBuzz(i + 1)
    case a if a % 3 == 0 => println("Fizz"); fizzBuzz(i + 1)
    case a if a % 5 == 0 => println("Buzz"); fizzBuzz(i + 1)
    case a => println(a); fizzBuzz(i + 1)
  }

  fizzBuzz(1)

}
