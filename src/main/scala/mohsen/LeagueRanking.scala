package mohsen

import scala.io.Source

case class TeamData(teamName: String, goalsFor: Int, goalsAgainst: Int)

object LeagueRanking:
  val ColumnTeamName = 1
  val columnGoalsFor = 6
  val columnGoalsAgainst = 8

  def parseFile(filePath: String): Iterable[TeamData] =
    Source.fromResource(filePath).getLines().map(_.trim.split("\\s+")).filter(_.length == 10).map { rawColumns =>
      TeamData(rawColumns(ColumnTeamName), rawColumns(columnGoalsFor).toInt, rawColumns(columnGoalsAgainst).toInt)
    }.toSeq

  def goalDifferentiate(teamData: TeamData): Int =
    Math.abs(teamData.goalsAgainst - teamData.goalsFor)

  def findSmallestGoalDifference(filePath: String): TeamData =
    parseFile(filePath).minBy(goalDifferentiate)


  def printTeamWithSmallestGoalDifference(filePath: String): Unit =
    println(s"The team with smallest goal difference is: ${findSmallestGoalDifference(filePath).teamName}")

