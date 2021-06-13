package mohsen

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class LeagueRankingSpecs extends AnyFlatSpec with Matchers :

  it should "parse .dat file" in {
    val ranking = LeagueRanking.parseFile("football.dat")
    ranking.size shouldBe 20
    ranking.head shouldBe TeamData("Arsenal", 79, 36)
  }

  it should "fail to parse badFile.dat" in {
    val exception = intercept[NumberFormatException] {
      LeagueRanking.parseFile("badFile.dat")
    }
    exception.getMessage shouldBe """For input string: "thirty""""
  }

  it should "find the team with smallest goal difference" in {
    LeagueRanking.findSmallestGoalDifference("football.dat").teamName shouldBe "Aston_Villa"
  }

