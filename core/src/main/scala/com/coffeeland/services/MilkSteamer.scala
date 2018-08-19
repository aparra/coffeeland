package com.coffeeland.services

import com.coffeeland.models.Milk.{FrothedMilk, Milk}

import scala.concurrent.{ExecutionContext, Future}

object MilkSteamer {

  def frothMilk(milk: Milk)(implicit ec: ExecutionContext): Future[FrothedMilk] =
    Future {
      println("milk frothing...")
      FrothedMilk(milk)
    }
}
