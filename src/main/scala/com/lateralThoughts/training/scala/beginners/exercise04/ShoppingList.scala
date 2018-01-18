package com.lateralThoughts.training.scala.beginners.exercise04

case class Article(
                    name: String,
                    priceWithoutCut: Double,
                    cutPercentage: Double,
                    category: String,
                    vatPercentage: Double,
                    quantity: Int,
                    ingredients: List[String]
                    ) {

  override def toString = this.name
}

object ShoppingList {

  def get = List(
    Article("Boeuf", 12.3, 0, "Viandes", 10, 1, List("Boeuf")),
    Article("Porc", 7.99, 5, "Viandes", 10, 1, List("Porc")),
    Article("Sauce Tomate", 2, 0, "Conserves", 10, 3, List("Tomate", "Eau", "Sel", "Sucre", "Conservateur")),
    Article("Petits Pois", 3.5, 10, "Conserves", 10, 2, List("Petits pois", "Eau", "Sel", "Conservateur")),
    Article("Thon", 1.50, 0, "Conserves", 20, 3, List("Thon", "Huile", "Sel", "Eau", "Conservateur"))
  )
}
