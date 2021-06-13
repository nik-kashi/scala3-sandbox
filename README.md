###Personal sandbox

1. Test for output stream:
   
   For testing functionality of a function with side effect
   we can use `spy` or `mock` to access the changes that are applying to system.
   Thus, it is necessary to use composition for accessing those methods(output stream)
   
   See `Printer.scala` and `PrinterSpecs.scala`
   
2. Test for calculating the area of a triangle:

   As dots of a triangle are global properties with a wide range of inputs, 
   the best solution for testing is _property testing_

   See `Triangle.scala` and `TriangleSpecs.scala`
   
3. The third item
   
   It had done with standard Scala API for reading file

   See `LeagueRanking.scala` and `LeagueRankingSpecs.scala`