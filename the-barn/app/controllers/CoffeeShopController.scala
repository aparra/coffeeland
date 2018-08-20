package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc._
import services.Barista

import scala.concurrent.ExecutionContext

@Singleton
class CoffeeShopController @Inject()(barista: Barista)(implicit ec: ExecutionContext) extends InjectedController {

  def cappuccino: Action[AnyContent] = Action.async {
    barista.prepareCappuccino().map(cappuccino => Ok(s"Enjoy your fancy ${cappuccino.name}! Made by The Barn."))
  }
}
