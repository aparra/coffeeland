package models

import com.coffeeland.models.CoffeeBeans.{ArabicaBeans, CoffeeBeans, RoastedCoffeeBeans, RobustaBeans}

object LooksLikeCoffeeBeans extends CoffeeBeans

object PoorBlendedCoffeeBeans extends RoastedCoffeeBeans(specie = mix(ArabicaBeans, RobustaBeans))
