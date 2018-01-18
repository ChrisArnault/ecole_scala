package com.lateralThoughts.training.scala.beginners.solutions.exercise04

import com.lateralThoughts.training.scala.beginners.exercise04.{Article, ShoppingList}

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

  def articlesWithMeat: List[Article] = shoppingList.filter(article => article.category == "Viandes")

  def pricesWithVat: List[(String, Double)] = shoppingList.map(article =>
    (article.name,
      article.priceWithoutCut * (1 + article.vatPercentage / 100) *
        article.quantity))

  def ingredientsList: List[String] = shoppingList
    .flatMap(article => article.ingredients)
    .distinct

  def totalInvoice: Double = shoppingList
    .map(getArticleTotalPrice)
    //.reduce((prix1,prix2) => prix1 + prix2)
    //.reduce(_ + _)
    .sum

  def getArticleTotalPrice: (Article) => Double = {
    article => article.priceWithoutCut * (1 + article.vatPercentage / 100) * (1 - article.cutPercentage / 100) * article.quantity
  }

  def totalFor(category: String): Double = shoppingList
    .filter(_.category == category)
    .map(getArticleTotalPrice)
    .sum

  def priceByCategory: List[(String, Double)] = {
    shoppingList
      .map(x => (x.category, getArticleTotalPrice(x)))
      .sortBy(_._1)
      .foldLeft(List[(String, Double)]())(sumByFirstTupleElement)

    shoppingList
      .groupBy(_.category)
      .mapValues(_.map(getArticleTotalPrice).sum)
      .toList

    shoppingList
      .groupBy(_.category)
      .map { x =>
        x match {
          case (key, values) => (key, values.map(getArticleTotalPrice).sum)
        } }
      .toList
  }

  def totalVat: Double = shoppingList
    .map(getArticleTotalVat)
    .reduce((prix1, prix2) => prix1 + prix2)

  def getArticleTotalVat: (Article) => Double = {
    article => article.priceWithoutCut * article.vatPercentage / 100 * (1 - article.cutPercentage / 100) * article.quantity
  }

  def totalCut: Double = shoppingList
    .map(getArticleTotalCut)
    .foldLeft(0d)((prix1, prix2) => prix1 + prix2)

  def getArticleTotalCut: (Article) => Double = {
    article => article.priceWithoutCut * (1 + article.vatPercentage / 100) * article.cutPercentage / 100 * article.quantity
  }

  def topIngredients(i: Int): List[String] = {
    shoppingList
      .flatMap(x => x.ingredients)
      .map(x => (x, 1d))
      .sortBy(_._1)
      .foldLeft(List[(String, Double)]())(sumByFirstTupleElement)
      .sortBy(x => -x._2)
      .map(x => x._1)
      .take(3)

    shoppingList.foldLeft(0d){(accum, value) =>
      val intermediate = accum + 1
      val result = value.ingredients.size
      result + intermediate
    }
    shoppingList
      .flatMap(_.ingredients)
      .groupBy(identity)
      .mapValues{ valeurs =>
        val decompte = valeurs.size
        decompte
      }
      .toList
      .sortBy { case (_, count) => -count }
      .map(_._1)
      .take(i)
  }

  def sumByFirstTupleElement(acc: List[(String, Double)], element: (String, Double)) = (acc, element) match {
    case (Nil, a) => a :: Nil
    case ((x1, x2) :: xs, (a, b)) if x1 == a => (x1, x2 + b) :: xs
    case (x :: xs, a) => a :: x :: xs
  }

  def allArticleNames: String = shoppingList.map(a => a.name).reduce((name1, name2) => name1 + ", " + name2)


}
