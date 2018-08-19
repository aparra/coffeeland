package com.coffeeland.services

import cats.data.Reader
import com.coffeeland.models.CoffeeBeans.GroundCoffee
import com.coffeeland.models.CoffeeDrinks.Espresso
import com.coffeeland.models.Water

import scala.concurrent.{ExecutionContext, Future}

object EspressoMachine {

  def brew(coffee: GroundCoffee, heatedWater: Water): Reader[ExecutionContext, Future[Espresso.type]] =
    Reader[ExecutionContext, Future[Espresso.type]] { implicit ec =>
      Future {
        println("brewing...")
        Espresso
      }
    }
}
