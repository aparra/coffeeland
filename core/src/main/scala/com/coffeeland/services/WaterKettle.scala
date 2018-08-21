package com.coffeeland.services

import com.coffeeland.models.Water
import javax.inject.{Inject, Singleton}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class WaterKettle @Inject()() {

  def heat(water: Water)(implicit ec: ExecutionContext): Future[Water] =
    Future {
      println("heating water...")
      water.copy(temperature = 85)
    }
}
