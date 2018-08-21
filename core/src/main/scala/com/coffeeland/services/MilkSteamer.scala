package com.coffeeland.services

import com.coffeeland.models.Milk.{FrothedMilk, Milk}
import javax.inject.{Inject, Singleton}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class MilkSteamer @Inject()() {

  def frothMilk(milk: Milk)(implicit ec: ExecutionContext): Future[FrothedMilk] =
    Future {
      println("milk frothing...")
      FrothedMilk(milk)
    }
}
