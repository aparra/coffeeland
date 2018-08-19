import com.coffeeland.models.CoffeeBeans.{ArabicaBeans, RobustaBeans}

package object models {

  val mix: (ArabicaBeans.type, RobustaBeans.type) => LooksLikeCoffeeBeans.type =
    (arabicaBeans, robustaBeans) => LooksLikeCoffeeBeans
}
