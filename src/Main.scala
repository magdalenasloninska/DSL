import test.MoneyTests

import scala.language.implicitConversions

// Author: Magdalena Słonińska

object Main extends App {
    MoneyTests().testConstructors()
    MoneyTests().testConversions()
    MoneyTests().testCashOperations()
    MoneyTests().testComparisons()
}