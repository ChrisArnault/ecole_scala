package com.lateralThoughts.training.scala.beginners.solutions.exercise01.advanced

// 100ième élément de la suite de Fibonacci
object Fibonacci extends App {

  def fibonacci(n:Int):BigInt = {
    def innerFib(iteration:Int, fib:BigInt, previousFib:BigInt):(BigInt, BigInt) = (fib, previousFib) match {
      case a if iteration == n  => a
      case (x, y) => innerFib(iteration+1, x+y, x)
    }

    innerFib(0, 1, 0)._1
  }

  println("Fibonacci de 100 : " + fibonacci(100))

}
