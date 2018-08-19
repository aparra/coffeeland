package com.coffeeland.services

import com.coffeeland.models.Water

import scala.concurrent.{ExecutionContext, Future}

object WaterKettle {

  def heat(water: Water)(implicit ec: ExecutionContext): Future[Water] =
    Future {
      println("heating water...")
      water.copy(temperature = 85)
    }
}
