package com.lateralThoughts.training.scala.beginners.exercise04

object Accountancy extends App {
  
  val shoppingList = ShoppingList.get

  println("Les articles de catégorie viande sont : " + articlesWithMeat)
  println("Les prix TTC sont : " + pricesWithVat)
  println("Les ingrédients sont : " + ingredientsList)
  println("Le total de la facture est : " + totalInvoice)
  println("Le total pour la catégorie viande est : " + totalFor("Viandes"))
  println("Les prix par catégorie sont : " + priceByCategory)
  println("Le total de TVA est : " + totalVat)
  println("Le total des réduction est : " + totalCut)
  println("Les trois premiers ingrédients sont : " + topIngredients(3))
  println("Le nom de tous les articles sont : " + allArticleNames)

  def articlesWithMeat:List[Article] = Nil

  def pricesWithVat:List[(String, Double)] = Nil

  def ingredientsList:List[String] = Nil

  def totalInvoice:Double = 0d

  def totalFor(category:String):Double = 0d

  def priceByCategory:List[(String, Double)] = Nil

  def totalVat:Double = 0d

  def totalCut:Double = 0d

  def topIngredients(i:Int):List[String] = Nil

  def allArticleNames:String = ""


}
