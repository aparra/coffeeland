package com.coffeeland.models

object Milk {

  sealed trait Milk

  object SkimMilk        extends Milk
  object LactoseFreeMilk extends Milk
  object OatMilk         extends Milk

  case class FrothedMilk(milk: Milk)
}
