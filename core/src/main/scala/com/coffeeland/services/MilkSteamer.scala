package com.coffeeland.services

import cats.data.Reader
import com.coffeeland.models.Milk.{FrothedMilk, Milk}

import scala.concurrent.{ExecutionContext, Future}

object MilkSteamer {

  def frothMilk(milk: Milk): Reader[ExecutionContext, Future[FrothedMilk]] =
    Reader[ExecutionContext, Future[FrothedMilk]] { implicit ec =>
      Future {
        println("milk frothing...")
        FrothedMilk(milk)
      }
    }
}
