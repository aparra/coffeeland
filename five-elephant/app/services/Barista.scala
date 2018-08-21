package services

import com.coffeeland.models.CoffeeDrinks.{Cappuccino, Espresso}
import com.coffeeland.models.Milk.{FrothedMilk, OatMilk}
import com.coffeeland.models.Water
import com.coffeeland.services.{EspressoMachine, Grinder, MilkSteamer, WaterKettle}
import javax.inject.{Inject, Singleton}
import models.FiveElephantCoffeeBeans

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class Barista @Inject()(grinder: Grinder,
                        waterKettle: WaterKettle,
                        espressoMachine: EspressoMachine,
                        milkSteamer: MilkSteamer)(implicit val ec: ExecutionContext) {

  def prepareCappuccino(): Future[Cappuccino.type] = {
    val combine: (Espresso.type, FrothedMilk) => Cappuccino.type =
      (espresso, foam) => Cappuccino

    val promiseEspresso = prepareEspresso()
    val promiseFoam     = milkSteamer.frothMilk(OatMilk)

    for {
      espresso <- promiseEspresso
      foam     <- promiseFoam
    } yield combine(espresso, foam)
  }

  private def prepareEspresso(): Future[Espresso.type] = {
    val promiseGround = grinder.grind(FiveElephantCoffeeBeans)
    val promiseWater  = waterKettle.heat(Water(temperature = 20))

    for {
      ground   <- promiseGround
      water    <- promiseWater
      espresso <- espressoMachine.brew(ground, water)
    } yield espresso
  }
}
