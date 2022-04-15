package test

import moneypackage.{$, Currency, CurrencyConverter, CurrencySymbol, EUR, Money, PLN, USD, `€`, zl}

import scala.language.implicitConversions

case class MoneyTests() {

    implicit def readNumberAsMoneyImplicit(newAmount: Double): Currency => Money = {
        (newCurrency: Currency) => Money(newAmount, newCurrency)(ExampleData.asInstanceOf[CurrencyConverter])
    }

    implicit def symbolToCurrencyImplicit(symbol: CurrencySymbol): Currency = {
        symbol.currency
    } // not the best place for implicits, move them somewhere where they are still visible

    def testConstructors() = {
        val example: Money = Money(3, EUR)(ExampleData.asInstanceOf[CurrencyConverter])
        assert(example.amount == 3)
        assert(example.currency == EUR)

        val exampleWithCurrency: Money = 100.0(PLN)
        assert(exampleWithCurrency.amount == 100)
        assert(exampleWithCurrency.currency == PLN)

        val exampleWithSymbol: Money = 15($)
        assert(exampleWithSymbol.amount == 15)
        assert(exampleWithSymbol.currency == USD)
    }

    def testConversions() = {
        val conversionExample1: Money = 20($) as EUR
        assert(conversionExample1.amount == 10)
        assert(conversionExample1.currency == EUR)

        val conversionExample2: Money = 8(zl) as $
        assert(conversionExample2.amount == 4)
        assert(conversionExample2.currency == USD)
    }

    def testCashOperations() = {
        val sum1: Money = 100.01(USD) + 200(EUR) //result in dollars (most left type)
        assert(sum1.amount == 500.01)
        assert(sum1.currency == USD)

        val sum2: Money = 100.01(zl) + 200($) //result in złoty (most left type)
        assert(sum2.amount == 500.01)
        assert(sum2.currency == PLN)

        val sum3: Money = 5(zl) + 3(PLN) + 20.5(USD) //result in złoty (most left type)
        assert(sum3.amount == 49)
        assert(sum3.currency == PLN)

        val sub: Money = 10($) - 17(zl)
        assert(sub.amount == 1.5)
        assert(sub.currency == USD)

        val mult: Money = 1.5(`€`) * 10
        assert(mult.amount == 15)
        assert(mult.currency == EUR)
    }

    def testComparisons() = {
        assert(1(EUR) > 1(PLN))
        assert(5(USD) < 7.25(USD))
    }
}
