package com.github.sobreera.play_min

import com.github.sobreera.play_min.controllers.SampleController
import org.scalatestplus.play.PlaySpec
import play.api.mvc.{Result, Results}
import play.api.test.Helpers._
import play.api.test.{FakeRequest, Helpers}

import scala.concurrent.Future

class SampleControllerSpec extends PlaySpec with Results {

  "SampleController#get" should {

    val controller = new SampleController(Helpers.stubControllerComponents())

    "クエリパラメータ通りのレスポンスを返す" in {
      val name = "sobreera"
      val result: Future[Result] = controller.get(Some(name)).apply(FakeRequest())
      val bodyText = Helpers.contentAsString(result)
      bodyText mustBe "Hello sobreera!"
    }

    "クエリパラメータが存在しなかった場合にはエラーメッセージを返す" in {
      val result: Future[Result] = controller.get(None)(FakeRequest())
      val bodyText = contentAsString(result)
      bodyText mustBe """Please give a name as a query parameter named "name"."""
    }
  }
}
