package services

import com.coffeeland.models.CoffeeDrinks.{Cappuccino, Espresso}
import com.coffeeland.models.Milk.{FrothedMilk, LactoseFreeMilk}
import com.coffeeland.models.Water
import com.coffeeland.services.{EspressoMachine, Grinder, MilkSteamer, WaterKettle}
import javax.inject.{Inject, Singleton}
import models.PoorBlendedCoffeeBeans

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class Barista @Inject()(implicit val ec: ExecutionContext) {

  def prepareCappuccino(): Future[Cappuccino.type] = {
    val putEverythingTogether: (Espresso.type, FrothedMilk) => Cappuccino.type =
      (espresso, foam) => Cappuccino

    for {
      espresso <- prepareEspresso()
      foam     <- MilkSteamer.frothMilk(LactoseFreeMilk)
    } yield putEverythingTogether(espresso, foam)
  }

  def prepareEspresso(): Future[Espresso.type] =
    for {
      water    <- WaterKettle.heat(Water(temperature = 20))
      ground   <- Grinder.grind(PoorBlendedCoffeeBeans)
      espresso <- EspressoMachine.brew(ground, water)
    } yield espresso
}
