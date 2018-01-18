package com.lateralThoughts.training.scala.beginners.exercise01.simple

/**
  * Rrenvoyer une chaine de caractères qui ne contient pas d'espaces en tête et en fin de chaine
  *
  * Par exemple "   Hello world  " doit renvoyer "Hello world"
  */
object TrimString extends App {

  val nonTrimmedString = "   Hello world  "

  val result = nonTrimmedString
    .dropWhile(char => char == ' ')
    .reverse
    .dropWhile(char => char == ' ')
    .reverse

  println(s" voilà le resultat '$result' ")

  val pattern = "[ ]*(.*)[ ]*".r
  val res = pattern.pattern.matcher(nonTrimmedString).group()
  println(s"deuxième resultat '$res' ")
}
