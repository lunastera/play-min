package com.github.sobreera.play_min.controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, Request, AnyContent, ControllerComponents}

@Singleton
class SampleController @Inject()(c: ControllerComponents) extends AbstractController(c) {

  def get(name: Option[String]) = Action { implicit request: Request[AnyContent] =>
      Ok {
        name
          .map(s => s"Hello $s!")
          .getOrElse("""Please give a name as a query parameter named "name".""")
      }
    }
}
