package com.coffeeland.services

import cats.data.Reader
import com.coffeeland.models.Water

import scala.concurrent.{ExecutionContext, Future}

object WaterKettle {

  def heat(water: Water): Reader[ExecutionContext, Future[Water]] =
    Reader[ExecutionContext, Future[Water]] { implicit ec =>
      Future {
        println("heating water...")
        water.copy(temperature = 85)
      }
    }
}
