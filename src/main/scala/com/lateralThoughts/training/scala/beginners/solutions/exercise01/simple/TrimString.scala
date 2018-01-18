package com.lateralThoughts.training.scala.beginners.solutions.exercise01.simple

import scala.io.StdIn.readLine

object TrimString extends App {

  val nonTrimmedString = readLine("Entrez la chaine de caractères : ")

  def trimStart(input:String):String = input match {
    case "" => ""
    case x if x.head != ' ' => x
    case x => trimStart(x.tail)
  }

  println("La chaine de caractères finale est " + trimStart(trimStart(nonTrimmedString).reverse).reverse)

}
