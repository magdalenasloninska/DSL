package test

import moneypackage.{CurrencyConverter, EUR, PLN, USD}

object ExampleData extends CurrencyConverter(Map(
    (PLN, EUR) -> 0.25,
    (PLN, USD) -> 0.5,
    (EUR, PLN) -> 4.0,
    (EUR, USD) -> 2.0,
    (USD, PLN) -> 2.0,
    (USD, EUR) -> 0.5)
)
