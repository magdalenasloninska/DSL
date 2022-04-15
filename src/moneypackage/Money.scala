package moneypackage

import scala.language.implicitConversions

case class Money(amount: BigDecimal, currency: Currency)(implicit currencyConverter: CurrencyConverter) {

    def as(endCurrency: Currency): Money = {
        if (currency != endCurrency) {
            Money(amount * currencyConverter.convert(currency, endCurrency), endCurrency)
        } else {
            Money(amount, currency)
        }
    }

    def +(other: Money): Money = Money(amount + (other as currency).amount, currency)

    def -(other: Money): Money = Money(amount - (other as currency).amount, currency)

    def *(multiplier: Double): Money = Money(amount * multiplier, currency)

    def <(other: Money): Boolean = amount < (other as currency).amount

    def >(other: Money): Boolean = amount > (other as currency).amount
}
