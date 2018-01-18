package com.lateralThoughts.training.scala.beginners.exercise05

import java.time.LocalDate
import java.io.File

import scala.util.{Failure, Success, Try}

sealed trait ValidationError
case class AgeVerificationError(reason: String) extends ValidationError
case class DateVerificationError(reason: String) extends ValidationError
case class CSVVerificationError(reason: String) extends ValidationError

case class Person(name: String, age: Int, birthDate: LocalDate)

object Person {

  type PersonOrValidationErrors = Either[Seq[ValidationError], Person]

  def osef() = {
    val data: Iterator[Person] = parse(???).get.filter(_.isRight).map(_.right.get)
  }
  def parse(file: File): Try[Iterator[PersonOrValidationErrors]] = {
    Try {
      val lines: Iterator[String] = scala.io.Source.fromFile(file).getLines
      lines.map(parseLine)
    }
  }

  def parseLine(line: String): PersonOrValidationErrors = {
    val array: Array[String] = line.split(';').map(_.trim).map(x => x.trim)
    val okCase = for {
      age <- Try(array(1).toInt)
      date <- Try(LocalDate.parse(array(2)))
    } yield Person(array(0), age, date)
    okCase match {
      case Success(ok) =>
        Right(ok)

      case Failure(nok) =>
        val sizeCheck: Option[CSVVerificationError] = array.size match {
          case 3 =>
            None
          case badSize =>
            Some(CSVVerificationError(s"Bad size $badSize expected 3"))
        }
        val ageCheck = ageVerification(array(1))
        val dateCheck = dateVerification(array(2))
        Left(sizeCheck.toList ++ ageCheck.left.toSeq ++ dateCheck.left.toSeq)
    }
  }

  def ageVerification(item: String): Either[ValidationError, Int] = {
    Try(item.toInt) match {
      case Success(age) =>
        Right(age)

      case Failure(ex) =>
        val err = AgeVerificationError("age is not an Int")
        Left(err)
    }
  }

  def dateVerification(item: String): Either[ValidationError, LocalDate] = {
    Try(LocalDate.parse(item)) match {
      case Success(dt) =>
        Right(dt)

      case Failure(ex) =>
        val err = DateVerificationError(s"error while parsing date ${ex.getMessage}")
        Left(err)
    }
  }
}
