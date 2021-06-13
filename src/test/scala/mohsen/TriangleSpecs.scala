package mohsen

import org.scalacheck.Gen
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.prop.Tables.Table
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.math.pow

class TriangleSpecs extends AnyFlatSpec with Matchers :

  it should "calculate triangle area successfully" in {
    val validCombinations = {
      Table(
        ("x1", "y1", "x2", "y2", "x3", "y3", "area"),
        (0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.5),
        (-1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0),
        //line area is zero
        (1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 0.0),
        (9.0, 0.0, -3.0, 4.0, 6.0, 6.0, 30.0)
      )
    }
    TableDrivenPropertyChecks.forAll(validCombinations) { (x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double, area: Double) =>
      Triangle(Dot(x1, y1), Dot(x2, y2), Dot(x3, y3)).area() shouldBe area
    }
  }

  it should "follow the `area to perimeter ratio` rule" in {
    val rangeMin = -100.0
    val rangeMax = 100.0
    val x1Gen = Gen.chooseNum(rangeMin, rangeMax)
    val y1Gen = Gen.chooseNum(rangeMin, rangeMax)
    val x2Gen = Gen.chooseNum(rangeMin, rangeMax)
    val y2Gen = Gen.chooseNum(rangeMin, rangeMax)
    val x3Gen = Gen.chooseNum(rangeMin, rangeMax)
    val y3Gen = Gen.chooseNum(rangeMin, rangeMax)

    //scala test only supports up to 6 generator. To add property test for scaleFactor, we can use two nested ScalaCheckPropertyChecks.forAll
    val scaleFactor = 8

    ScalaCheckPropertyChecks.forAll(x1Gen, y1Gen, x2Gen, y2Gen, x3Gen, y3Gen) { (x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double) =>
      val mainArea = Triangle(Dot(x1, y1), Dot(x2, y2), Dot(x3, y3)).area()
      val scaledArea = Triangle(Dot(x1 * scaleFactor, y1 * scaleFactor), Dot(x2 * scaleFactor, y2 * scaleFactor), Dot(x3 * scaleFactor, y3 * scaleFactor)).area()
      mainArea * pow(scaleFactor, 2) shouldBe scaledArea
    }
  }
