package com.lateralThoughts.training.scala.beginners.exercise03

import scala.annotation.tailrec

object FunctionalProgramming {

  @tailrec
  def factorial(n:Int, state: Long = 1): Long = {
    if (n <= 1)
      state
    else
      factorial(n - 1, n * state)
  }

  def reverse[A](aList:List[A]):List[A] = {
    if (aList.isEmpty) {
      assert(aList == Nil)
      Nil
    } else {
      val head: A = aList.head
      val tail: List[A] = aList.tail
      reverse(tail) ++ List(head)
    }

  }

  def map[A,B](aList:List[A], f: A => B):List[B] = {
    if (aList.isEmpty) {
      Nil
    } else {
      val head: A = aList.head
      val tail: List[A] = aList.tail
      f(head) :: map(tail, f)
    }

    aList.map(f)
  }

  def sum (x: Int, y: Int = 2, z: Int = 4) = ???

  sum(1)
  sum(x = 11, z = 1)

  def filter[A](aList:List[A], f: A => Boolean):List[A] = ???

}
