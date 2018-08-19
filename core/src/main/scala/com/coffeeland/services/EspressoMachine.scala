package com.coffeeland.services

import com.coffeeland.models.CoffeeBeans.GroundCoffee
import com.coffeeland.models.CoffeeDrinks.Espresso
import com.coffeeland.models.Water

import scala.concurrent.{ExecutionContext, Future}

object EspressoMachine {

  def brew(coffee: GroundCoffee, heatedWater: Water)(implicit ec: ExecutionContext): Future[Espresso.type] =
    Future {
      println("brewing...")
      Espresso
    }
}
