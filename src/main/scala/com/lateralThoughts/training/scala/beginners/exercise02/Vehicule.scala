package com.lateralThoughts.training.scala.beginners.exercise02

abstract class Vehicule {
  def makeNoise()
  def fix = println("C'est réparé")
}
class Moto(brand: String) extends Vehicule {
  override def makeNoise() = {
    println("BroumBroum")
    "toto"
  }
}
class Voiture(brand: String) extends Vehicule {
  override def makeNoise(): Unit = println("VroumVroum")
}
class Velo(brand: String) extends Vehicule {
  override def makeNoise(): Unit = println("DringDring")
}
class Driver(name: String) {
  def drive(vehicule: Vehicule) = {
    vehicule.makeNoise()
  }
}
trait CanFly {self: Vehicule =>
  def takeOff() {println("Ca décolle")}

  override def fix: Unit = println("")
}
class Plane extends Vehicule with CanFly {
  override def makeNoise(): Unit = println("Vraoum")
}

class Helicopter extends Vehicule with CanFly {
  override def makeNoise(): Unit = println("FlapFlap")
}

object DriverMain {
  def main(args: Array[String]): Unit = {
    val ryan = new Driver("Ryan Gosling")
    val voiture: Voiture with CanFly =
      new Voiture("Delorean") with CanFly
    ryan.drive(voiture)
  }
}


