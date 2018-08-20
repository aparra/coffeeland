package com.coffeeland.models

object CoffeeDrinks {

  trait CoffeeDrink {
    def name: String
  }

  object Espresso extends CoffeeDrink {
    val name = "Espresso"
  }

  object Cappuccino extends CoffeeDrink {
    val name = "Cappuccino"
  }
}
