package com.coffeeland.services

import com.coffeeland.models.CoffeeBeans.{GroundCoffee, RoastedCoffeeBeans}
import javax.inject.{Inject, Singleton}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class Grinder @Inject()() {

  def grind(beans: RoastedCoffeeBeans)(implicit ec: ExecutionContext): Future[GroundCoffee] =
    Future {
      println("grinding...")
      GroundCoffee(beans)
    }
}
