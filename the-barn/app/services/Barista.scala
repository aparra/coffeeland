package services

import com.coffeeland.models.CoffeeDrinks.{Cappuccino, Espresso}
import com.coffeeland.models.Milk.{FrothedMilk, OatMilk}
import com.coffeeland.models.Water
import com.coffeeland.services.{EspressoMachine, Grinder, MilkSteamer, WaterKettle}
import models.TheBarnCoffeeBeans

import scala.concurrent.{ExecutionContext, Future}

class Barista(implicit val ec: ExecutionContext) {

  def prepareCappuccino(): Future[Cappuccino.type] = {
    val combine: (Espresso.type, FrothedMilk) => Cappuccino.type =
      (espresso, foam) => Cappuccino

    val promiseEspresso = prepareEspresso()
    val promiseFoam     = MilkSteamer.frothMilk(OatMilk)

    for {
      espresso <- promiseEspresso
      foam     <- promiseFoam
    } yield combine(espresso, foam)
  }

  def prepareEspresso(): Future[Espresso.type] =
    for {
      water    <- WaterKettle.heat(Water(temperature = 20))
      ground   <- Grinder.grind(TheBarnCoffeeBeans)
      espresso <- EspressoMachine.brew(ground, water)
    } yield espresso
}
