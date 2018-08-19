package com.coffeeland.models

object CoffeeBeans {

  sealed trait CoffeeBeans

  object RobustaBeans extends CoffeeBeans
  object ArabicaBeans extends CoffeeBeans

  case class RoastedCoffeeBeans(specie: CoffeeBeans)

  case class GroundCoffee(beans: RoastedCoffeeBeans)
}
