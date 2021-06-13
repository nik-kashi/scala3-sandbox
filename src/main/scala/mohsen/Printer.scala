package mohsen

import java.io.PrintStream

object Printer:
  def print(implicit out: PrintStream = System.out): Unit =
    Range.inclusive(1, 10).map(_.toString).foreach(out.println)
