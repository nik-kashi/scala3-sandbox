package mohsen

@main
def app =
  //First item
  Printer.print()
  //Second item
  println(s"The area of a sample triangle is: ${Triangle(Dot(0, 0), Dot(0, 2), Dot(2, 0)).area()}")
  //Third item
  LeagueRanking.printTeamWithSmallestGoalDifference("football.dat")
