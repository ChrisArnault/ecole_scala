package com.lateralThoughts.training.scala.beginners.exercise05

import com.lateralThoughts.training.scala.beginners.exercise05.Person.PersonOrValidationErrors
import org.scalatest.{FlatSpec, FunSuite, Matchers}

class PersonTest extends FlatSpec with Matchers {

  "parse" should "work with a file" in {
    val file =
      new java.io.File("/Users/ogirardot/Documents/Formations/training-materials/scala/beginners/projects/basis/src/test/resources/test-good.csv")
    Person.parse(file).isSuccess should be (true)
  }


  "parseLine" should "check my age as an integer" in {
    val personOrErr: Either[Seq[ValidationError], Person] = Person.parseLine("toto;12.3;2017-01-01")
    personOrErr.isLeft should be (true)
    val errors: Seq[ValidationError] = personOrErr.left.get
    errors should have size(1)
    errors(0) should be (AgeVerificationError("age is not an Int"))
  }
}
