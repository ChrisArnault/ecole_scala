package com.lateralThoughts.training.scala.beginners.exercise05

import scala.concurrent.Future
import scala.util.{Failure, Success}

case class User(id: Long, email: Option[String])

object OptionTest {

  def fetchUser(id: Long): Option[User] = {
    if (id == 1) {
      Some(User(1, Some("toto@gmail.com")))
    } else
      None
  }

  def fetchUserIfEmail(id: Long): Option[User] = {
    fetchUser(id).filter(_.email.isDefined)
  }

  def showEmail(id: Long): Option[String] = {
    fetchUser(id).flatMap(user => user.email)
  }

  def main(args: Array[String]): Unit = {
    showEmail(-1) match {
      case Some(email) =>

      case None =>
    }

    showEmail(-1).map(email => email).getOrElse("N/C")

    /*for {
      futureResultat <- showEmail(-1L)
      email <- futureResultat
    } yield email*/
  }
}
