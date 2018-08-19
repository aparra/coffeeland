package com.coffeeland.services

import com.coffeeland.models.CoffeeBeans.{GroundCoffee, RoastedCoffeeBeans}

import scala.concurrent.{ExecutionContext, Future}

object Grinder {

  def grind(beans: RoastedCoffeeBeans)(implicit ec: ExecutionContext): Future[GroundCoffee] =
    Future {
      println("grinding...")
      GroundCoffee(beans)
    }
}
