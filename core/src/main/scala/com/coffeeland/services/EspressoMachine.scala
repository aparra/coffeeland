package com.coffeeland.services

import com.coffeeland.models.CoffeeBeans.GroundCoffee
import com.coffeeland.models.CoffeeDrinks.Espresso
import com.coffeeland.models.Water
import javax.inject.{Inject, Singleton}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class EspressoMachine @Inject()() {

  def brew(coffee: GroundCoffee, heatedWater: Water)(implicit ec: ExecutionContext): Future[Espresso.type] =
    Future {
      println("brewing...")
      Espresso
    }
}
