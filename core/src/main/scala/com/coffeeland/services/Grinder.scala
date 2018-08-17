package com.coffeeland.services

import cats.data.Reader
import com.coffeeland.models.CoffeeBeans.{GroundCoffee, RoastedCoffeeBeans}

import scala.concurrent.{ExecutionContext, Future}

object Grinder {

  def grind(beans: RoastedCoffeeBeans): Reader[ExecutionContext, Future[GroundCoffee]] =
    Reader[ExecutionContext, Future[GroundCoffee]] { implicit ec =>
      Future {
        println("grinding...")
        GroundCoffee(beans)
      }
    }
}
