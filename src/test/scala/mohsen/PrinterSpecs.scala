package mohsen

import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito._
import org.scalatest.flatspec._
import org.scalatest.matchers._
import org.scalatestplus.mockito.MockitoSugar

import java.io.PrintStream

class PrinterSpecs extends AnyFlatSpec with should.Matchers with MockitoSugar :
  implicit val printStreamMock: PrintStream = mock[PrintStream]
  val printBuffer = new StringBuilder
  when(printStreamMock.println(any[String])).`then`(a => printBuffer.append(a.getArgument[String](0)).append("\n"))
  it should "print 1 to 10" in {
    Printer.print(printStreamMock)
    printBuffer.toString() shouldBe "1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n"
  }

